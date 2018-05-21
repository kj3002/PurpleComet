package Numbers;

import General.Conversions;

import java.math.BigInteger;
import java.util.ArrayList;

public class Number {
	protected long numInteger;
	protected ArrayList<Long> coefficients;
	protected ArrayList<Long> indexes;
	protected ArrayList<Number> radicands;
	protected long denominator;
	
	/**
	 * @param numInteger - integer that starts the numerator (1 in phi, for instance)
	 * @param coefficients - the coefficients for the radicals in the numerator (integers only)
	 * @param indexes - the indexes for the radicals in the numerator (integers only)
	 * @param radicands - the radicands for the radicals in the numerator (any Number)
	 * @param denominator - integer that starts the denominator (2 in phi, for instance)
	 */
	public Number(long numInteger, ArrayList<Long> coefficients, ArrayList<Long> indexes, ArrayList<Number> radicands, long denominator) {
		this.numInteger = numInteger;
		this.coefficients = General.Conversions.longListToLongList(coefficients);
		this.indexes = General.Conversions.longListToLongList(indexes);
		this.radicands = General.Conversions.numberListToNumberList(radicands);
		this.denominator = denominator;
		this.simplify();
	}
	public Number(int numInteger, ArrayList<Integer> coefficients, ArrayList<Integer> indexes, ArrayList<Number> radicands, int denominator) {
		this (numInteger, Conversions.intListToLongList(coefficients), Conversions.intListToLongList(indexes), radicands, denominator);
	}
	public Number(long numInteger, long coefficient, long index, Number radicand, long denominator) {
		this.numInteger = numInteger;
		this.coefficients = new ArrayList<>();
		this.coefficients.add(coefficient);
		this.indexes = new ArrayList<>();
		this.indexes.add(index);
		this.radicands = new ArrayList<>();
		this.radicands.add(radicand);
		this.denominator = denominator;
		this.simplify();
	}
	public Number(int numInteger, int coefficient, int index, Number radicand, int denominator) {
		this((long)numInteger, (long)coefficient, (long)index, radicand, (long)denominator);
	}
	public Number(int numInteger, int coefficient, int index, int radicand, int denominator) {
		this(numInteger, coefficient, index, new Number(radicand), denominator);
	}
	public Number(long coefficient, long index, Number radicand) {
		this(0, coefficient, index, radicand, 1);
	}
	public Number(int coefficient, int index, Number radicand) {
		this((long)coefficient, (long)index, radicand);
	}
	public Number(long coefficient, long index, long radicand) {
		this(coefficient, index, new Number(radicand));
	}
	public Number(int coefficient, int index, int radicand) {
		this((long)coefficient, (long)index, (long)radicand);
	}
	public Number(long numInteger, long denominator) {
		this(numInteger, null, null, null, denominator);
	}
	public Number(int numInteger, int denominator) {
		this((long)numInteger, (long)denominator);
	}
	public Number(long number) {
		this(number, 1);
	}
	public Number(int number) {
		this((long)number);
	}
	public Number() {
		this(0);
	}

	protected void simplify() {
		//convert nulls to ArrayLists with length 0
		if (this.coefficients == null) {
			this.coefficients = new ArrayList<>();
		}
		if (this.indexes == null) {
			this.indexes = new ArrayList<>();
		}
		if (this.radicands == null) {
			this.radicands = new ArrayList<>();
		}
		
		// ensure no immediate errors
		if (this.indexes.contains(0)) {
			throw new IllegalArgumentException("Cannot take the 0th root.");
		} else if (this.denominator == 0) {
			throw new IllegalArgumentException("Cannot divide by 0.");
		} else if (this.coefficients.size() != this.indexes.size() || this.indexes.size() != this.radicands.size()) {
			throw new IllegalArgumentException("Size of numerator radical arrays are not equivalent.");
		}
		
		// remove radicals that should not be there
		boolean changeMade = false;
		ArrayList<Number> removed = new ArrayList<>();
		for (int in = 0; in < this.coefficients.size(); in++) {
			if (this.coefficients.get(in) == 0 || this.radicands.get(in).equals(0)) {
				this.removeRadical(in);
				in--;
				changeMade = true;
			} else if (this.radicands.get(in).equals(1)) {
				this.numInteger += this.coefficients.get(in);
				this.removeRadical(in);
				in--;
				changeMade = true;
			} else if (this.indexes.get(in) == 1) {
				removed.add(this.radicands.get(in).multiply(new Number(this.coefficients.get(in)))); // save for later - ensure full simplification
				this.removeRadical(in);
				removed.get(removed.size() - 1).setDenominator(this.denominator);
				in--;
				changeMade = true;
			}
		}
		
		// re-add the radicands that had an index of 1, without the root
		for (Number n : removed) {
			this.numInteger += n.numInteger;
			this.coefficients.addAll(n.coefficients);
			this.indexes.addAll(n.indexes);
			this.radicands.addAll(n.radicands);
		}
		
		// simplify each radical numerator
		for (int in = 0; in < this.coefficients.size(); in++) {
			long gcf = this.radicands.get(in).getNumeratorGCF(), ogcf = gcf;
			int coef = 1;
			// simplify the (this.index.get(in))th root of gcf
			for (int testCoef = (int)Math.sqrt(gcf); testCoef > 1; testCoef--) {
				if (gcf % Math.pow(testCoef, this.indexes.get(in)) == 0) {
					coef = testCoef;
					break;
				}
			}
			gcf /= (int)Math.pow(coef, this.indexes.get(in));
			long[] newRad = { coef, gcf };
			this.coefficients.set(in, this.coefficients.get(in) * newRad[0]);
			Number rad = this.radicands.get(in);
			rad.numInteger *= newRad[1];
			rad.numInteger /= ogcf;
			for (int radIn = 0; radIn < rad.coefficients.size(); radIn++) {
				rad.coefficients.set(radIn, rad.coefficients.get(radIn) / ogcf * newRad[1]);
			}
			if (gcf != ogcf) {
				changeMade = true;
			}
		}

		// simplify each radical denominator
		for (int radIn = 0; radIn < this.coefficients.size(); radIn++) {
			long denom = this.radicands.get(radIn).denominator, odenom = denom;
			int coef = 1;
			// simplify the (this.index.get(radIn))th root of denom
			for (int testCoef = (int)Math.sqrt(denom); testCoef > 1; testCoef--) {
				if (denom % Math.pow(testCoef, this.indexes.get(radIn)) == 0) {
					coef = testCoef;
					break;
				}
			}
			denom /= (int)Math.pow(coef, this.indexes.get(radIn));
			if (denom != odenom) {
				this.radicands.get(radIn).denominator = denom;
				this.numInteger *= coef;
				this.denominator *= coef;
				for (int in = 0; in < this.coefficients.size(); in++) {
					if (in != radIn) {
						this.coefficients.set(in, this.coefficients.get(in) * coef);
					}
				}
				changeMade = true;
			}

			// find and combine like terms
			for (int in1 = 0; in1 < this.coefficients.size() - 1; in1++) {
				for(int in2 = in1 + 1; in2 < this.coefficients.size(); in2++) {
					if (this.indexes.get(in1) == this.indexes.get(in2) && this.radicands.get(in1).equals(this.radicands.get(in2))) {
						this.coefficients.set(in1, this.coefficients.get(in1) + this.coefficients.get(in2));
						this.removeRadical(in2);
						in2--;
						changeMade = true;
					}
				}
			}
		}

		// simplify numerator and denominator
		long gcf = this.getNumeratorGCF();
		gcf = BigInteger.valueOf(gcf).gcd(BigInteger.valueOf(this.denominator)).intValue();
		if (this.denominator < 0) gcf *= -1;
		this.numInteger /= gcf;
		this.denominator /= gcf;
		for (int in = 0; in < this.coefficients.size(); in++) {
			this.coefficients.set(in, this.coefficients.get(in) / gcf);
		}
		if (gcf != 1) {
			changeMade = true;
		}
		// if this is 0, make denominator 1 (equals(0) and toString() relies on denominator of 1)
		if (this.numInteger == 0 && this.coefficients.size() == 0) {
			this.denominator = 1;
		}

		// if a change was made, call again
		if (changeMade) simplify();
	}
	
	public Number removeRadical(int index) {
		long coef = this.coefficients.remove(index);
		long in = this.indexes.remove(index);
		Number rad = this.radicands.remove(index);
		if (rad.equals(1)) {
			return new Number(coef);
		} if (coef == 0 || rad.equals(0)) {
			return new Number();
		} if (in == 1) {
			return rad.multiply(new Number(coef));
		}
		return new Number(coef, in, rad);
	}
	
	public boolean equals(int n) {
		return this.isInteger() && this.numInteger == n;
	}
	public boolean equals(Number n) {
		if (this.coefficients.size() != n.coefficients.size() || this.numInteger != n.numInteger || this.denominator != n.denominator) {
			return false;
		}
		Number thisClone = this.clone(), nClone = n.clone();
		for (int in1 = 0; in1 < thisClone.coefficients.size(); in1++) {
			for (int in2 = 0; in2 < nClone.coefficients.size(); in2++) {
				if (thisClone.coefficients.get(in1) == nClone.coefficients.get(in2) && thisClone.indexes.get(in1) == nClone.indexes.get(in2) && thisClone.radicands.get(in1).equals(nClone.radicands.get(in2))) {
					thisClone.removeRadical(in1);
					nClone.removeRadical(in2);
					in1--;
					in2--;
				}
			}
		}
		return thisClone.coefficients.size() == 0;
	}
	
	public boolean isRational() {
		return this.coefficients.size() == 0;
	}
	
	public boolean isInteger() {
		return this.isRational() && this.denominator == 1;
	}
	
	public boolean isRadical() {
		return this.numInteger == 0 && this.coefficients.size() == 1 && this.denominator == 1;
	}
	
	public long getNumeratorGCF() {
		long gcf = this.numInteger;
		if (this.numInteger == 0) {
			if (this.coefficients.size() > 0) {
				gcf = this.coefficients.get(0);
			} else {
				return 1; // in this case, this is equal to 0 (this.equals(0) returns true)
			}
		}
		for (long coef : this.coefficients) {
			gcf = BigInteger.valueOf(gcf).gcd(BigInteger.valueOf(coef)).intValue();
		}
		return gcf;
	}
	
	public long getNumeratorInteger() {
		return numInteger;
	}
	public void setNumeratorInteger(long numeratorInteger) {
		this.numInteger = numeratorInteger;
		this.simplify();
	}
	public ArrayList<Long> getCoefficients() {
		return coefficients;
	}
	public void setCoefficients(ArrayList<Long> coefficients) {
		this.coefficients = coefficients;
		this.simplify();
	}
	public ArrayList<Long> getIndexes() {
		return indexes;
	}
	public void setIndexes(ArrayList<Long> indexes) {
		this.indexes = indexes;
		this.simplify();
	}
	public ArrayList<Number> getRadicands() {
		return radicands;
	}
	public void setRadicands(ArrayList<Number> radicands) {
		this.radicands = radicands;
		this.simplify();
	}
	public Number getNumerator() {
		return new Number(this.numInteger, this.coefficients, this.indexes, this.radicands, 1);
	}
	public void setNumerator(Number numerator) {
		this.numInteger = numerator.numInteger;
		this.coefficients = General.Conversions.longListToLongList(numerator.coefficients);
		this.indexes = General.Conversions.longListToLongList(numerator.indexes);
		this.radicands = General.Conversions.numberListToNumberList(numerator.radicands);
	}
	public long getDenominator() {
		return this.denominator;
	}
	public void setDenominator(long denominator) {
		if (denominator == 0) throw new IllegalArgumentException("Cannot divide by 0");
		this.denominator = denominator;
	}
	public void set(Number num) {
		this.numInteger = num.numInteger;
		this.coefficients = General.Conversions.longListToLongList(num.coefficients); // clone so it isnt the same reference
		this.indexes = General.Conversions.longListToLongList(num.indexes);
		this.radicands = General.Conversions.numberListToNumberList(num.radicands);
		this.denominator = num.denominator;
		this.simplify();
	}
	public Number getRadical(int radicalIndex) {
		return new Number(this.coefficients.get(radicalIndex), this.indexes.get(radicalIndex), this.radicands.get(radicalIndex));
	}
	
	public Number add(Number number) {
		Number num1 = new Number(), num2 = new Number();
		num1.set(this);
		num2.set(number);
		long gcf = BigInteger.valueOf(num1.denominator).gcd(BigInteger.valueOf(num2.denominator)).longValue(),
				mult1 = num2.denominator / gcf, mult2 = num1.denominator / gcf;
		num1.numInteger *= mult1;
		for (int in = 0; in < num1.coefficients.size(); in++) {
			num1.coefficients.set(in, num1.coefficients.get(in) * mult1);
		}
		num2.numInteger *= mult2;
		for (int in = 0; in < num2.coefficients.size(); in++) {
			num2.coefficients.set(in, num2.coefficients.get(in) * mult2);
		}
		
		ArrayList<Long> coefs = new ArrayList<>(), ins = new ArrayList<>();
		ArrayList<Number> rads = new ArrayList<>();
		coefs.addAll(num1.coefficients);
		coefs.addAll(num2.coefficients);
		ins.addAll(num1.indexes);
		ins.addAll(num2.indexes);
		rads.addAll(num1.radicands);
		rads.addAll(num2.radicands);
		Number ret = new Number(num1.numInteger + num2.numInteger, coefs, ins, rads, num1.denominator * num2.denominator);
		return ret;
	}
	
	public Number subtract(Number number) {
		return this.add(number.multiply(new Number(-1)));
	}
	
	public Number multiply(Number number) {
		ArrayList<Long> coefs = new ArrayList<>();
		ArrayList<Long> ins = new ArrayList<>();
		ArrayList<Number> rads = new ArrayList<>();
		for (int in = 0; in < this.coefficients.size(); in++) {
			coefs.add(this.coefficients.get(in) * number.numInteger);
			ins.add(this.indexes.get(in));
			rads.add(this.radicands.get(in));
		}
		for (int in = 0; in < number.coefficients.size(); in++) {
			coefs.add(number.coefficients.get(in) * this.numInteger);
			ins.add(number.indexes.get(in));
			rads.add(number.radicands.get(in));
		}
		
		for (int thisIn = 0; thisIn < this.coefficients.size(); thisIn++) {
			for (int numIn = 0; numIn < number.coefficients.size(); numIn++) {
				long thisIndex = this.indexes.get(thisIn), numIndex = number.indexes.get(numIn);
				long lcm = thisIndex * numIndex / BigInteger.valueOf(thisIndex).gcd(BigInteger.valueOf(numIndex)).intValue();
				long thisMult = lcm / thisIndex, numMult = lcm / numIndex;
				Number thisRad = this.radicands.get(thisIn).exponentiate(thisMult), numRad = number.radicands.get(numIn).exponentiate(numMult);
				coefs.add(this.coefficients.get(thisIn) * number.coefficients.get(numIn));
				ins.add(lcm);
				rads.add(thisRad.multiply(numRad));
			}
		}
		return new Number(this.numInteger * number.numInteger, coefs, ins, rads, this.denominator * number.denominator);
	}
	
	public Number divide(Number number) {
		return new Number(); // TODO divide in Number (see exponentiate)
		//return this.multiply(number.reciprocal);
	}
	
	public Number exponentiate(long pow) {
		Number ret = new Number(1);
		for (int n = 0; n < Math.abs(pow); n++) {
			ret = ret.multiply(this);
		}
		if (pow < 0) System.out.println("Calling reciprocal with " + this + " pow: " + pow);
		return pow < 0 ? ret.reciprocal() : ret;
	}

	public Number reciprocal() {
		if (this.equals(0)) throw new IllegalArgumentException("Cannot take the reciprocal of 0");
		Number numerator = this.getNumerator();
		ArrayList<Number> multipliers = new ArrayList<>();
		for (int in = 0; in < numerator.coefficients.size(); in++) {
			Number mult = new Number();
			Number x = numerator.getRadical(in), y = new Number(-numerator.numInteger);
			for (int pow = 0; pow < numerator.indexes.get(in); pow++) {
				Number add;
				if (y.equals(0) && numerator.indexes.get(in) - pow - 1 == 0) {
					add = x.exponentiate(pow);
				} else {
					add = x.exponentiate(pow).multiply(y.exponentiate(numerator.indexes.get(in) - pow - 1));
				}
				mult = mult.add(add);
			}
			mult = mult.multiply(new Number(x.radicands.get(0).denominator));
			multipliers.add(mult);
			numerator.numInteger = -(long)Math.pow(y.numInteger, numerator.indexes.get(in)) + x.radicands.get(0).numInteger;
			numerator.coefficients.addAll(x.radicands.get(0).coefficients);
			numerator.indexes.addAll(x.radicands.get(0).indexes);
			numerator.radicands.addAll(x.radicands.get(0).radicands);
		}
		Number ret = new Number(this.getDenominator());
		for (Number mult : multipliers) {
			//System.out.println("ret is: " + ret + " multiplying by: " + mult);
			ret = ret.multiply(mult);
		}
		ret.setDenominator(numerator.numInteger);
		//System.out.println("ret is: " + ret);
		ret.simplify();
		return ret;
	}
	
	@Override
	public String toString() {
		String ret = this.denominator == 1 ? "" : "(";
		ret += this.numInteger == 0 ? "" : this.numInteger;
		for (int in = 0; in < this.coefficients.size(); in++) {
			ret += this.numInteger == 0 && in == 0 ? "" : " + ";
			ret += this.coefficients.get(in) == 1 ? "" : this.coefficients.get(in) + " * ";
			ret += this.indexes.get(in) == 2 ? "" : this.indexes.get(in);
			ret += "\u221A(" + this.radicands.get(in).toString() + ")";
		}
		ret += this.denominator == 1 ? "" : ") / " + this.denominator;
		return ret.equals("") ? "0" : ret;
	}

	@Override
	public Number clone() {
		return new Number(this.numInteger, Conversions.longListToLongList(this.coefficients), Conversions.longListToLongList(this.indexes), Conversions.numberListToNumberList(this.radicands), this.denominator);
	}
}
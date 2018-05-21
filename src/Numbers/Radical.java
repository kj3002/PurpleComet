package Numbers;

public class Radical extends Number {
	public Radical(int coefficient, int index, int radicand) {
		super(coefficient, index, new Int(radicand));
	} public Radical(int index, int radicand) {
		this(1, index, radicand);
	} public Radical(int radicand) {
		this(2, radicand);
	}

	public long getCoefficient() {
		return this.coefficients.size() == 1 ? this.coefficients.get(0) : this.numInteger;
	}
	public long getIndex() {
		return this.indexes.size() == 1 ? this.indexes.get(0) : 1;
	}
	public long getRadicand() {
		return this.radicands.size() == 1 ? this.radicands.get(0).numInteger : 1;
	}
}

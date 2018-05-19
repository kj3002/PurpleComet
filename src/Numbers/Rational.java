package Numbers;

public class Rational extends Number {
	public Rational(int numerator, int denominator) {
		super(numerator, denominator);
	}
	public Rational(long numerator, long denominator) {
		super(numerator, denominator);
	}

	public long[] toArray() {
		long[] ret = { this.numInteger, this.denominator };
		return ret;
	}
}

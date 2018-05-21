package Numbers;

public class Int extends Rational {
	public Int(long number) {
		super(number, 1);
	} public Int(int number) {
		this((long)number);
	}
}

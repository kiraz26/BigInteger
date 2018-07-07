package biginteger;

public class Main {

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("+1234");
		System.out.println(b1);
		BigInteger b2 = new BigInteger("+123454");
		System.out.println(b2);
		b1.add(b2);
	}

}

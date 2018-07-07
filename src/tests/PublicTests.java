package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import biginteger.BigInteger;

public class PublicTests {

	@Test
	public void testCons1() {
		BigInteger b1 = new BigInteger("+12345678901234567890");
		String result = b1.toString();
		String expected = "12345678901234567890";
		assertEquals(expected, result);
	}

	@Test
	public void testCons2() {
		BigInteger b1 = new BigInteger("-1234567890123456789");
		String result = b1.toString();
		String expected = "-1234567890123456789";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCons3() {
		BigInteger b1 = new BigInteger("+1234678901234567890111111");
		String result = b1.toString();
		String expected = "1234678901234567890111111";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCons4() {
		BigInteger b1 = new BigInteger();
		String result = b1.toString();
		String expected = "0";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCons5() {
		BigInteger b1 = new BigInteger("");
		String result = b1.toString();
		String expected = "0";
		assertEquals(expected, result);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCons6() {
		BigInteger b1 = new BigInteger("+123abc");
	}
	
	@Test
	public void testCons7() {
		BigInteger b = new BigInteger("13579111315171921232527");
		BigInteger b1 = new BigInteger(b);
		String result = b1.toString();
		String expected = "13579111315171921232527";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCons8() {
		BigInteger b = new BigInteger("-24681012141618202224262830");
		BigInteger b1 = new BigInteger(b);
		String result = b1.toString();
		String expected = "-24681012141618202224262830";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCons9() {
		BigInteger b1 = new BigInteger("123456789012345678901234567890");
		String result = b1.toString();
		String expected = "123456789012345678901234567890";
		assertEquals(expected, result);
	}
	
	@Test
	public void testSub1() {
		BigInteger b1 = new BigInteger("1357");
		BigInteger b2 = new BigInteger("2468");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "-1111";
		assertEquals(expected, result);
	}

	@Test
	public void testSub2() {
		BigInteger b1 = new BigInteger("8357");
		BigInteger b2 = new BigInteger("7468");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "889";
		assertEquals(expected, result);
	}

	@Test
	public void testSub3() {
		BigInteger b1 = new BigInteger("8357");
		BigInteger b2 = new BigInteger("68");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "8289";
		assertEquals(expected, result);
	}

	@Test
	public void testSub4() {
		BigInteger b1 = new BigInteger("57");
		BigInteger b2 = new BigInteger("7468");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "-7411";
		assertEquals(expected, result);
	}

	@Test
	public void testSub5() {
		BigInteger b1 = new BigInteger("8357");
		BigInteger b2 = new BigInteger("-7469");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "15826";
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testSub6() {
		BigInteger b1 = new BigInteger("-8357");
		BigInteger b2 = new BigInteger("7468");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "-15825";
		assertEquals(expected, result);
	}
	
	@Test
	public void testSub7() {
		BigInteger b1 = new BigInteger("-8357");
		BigInteger b2 = new BigInteger("-8357");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "0";
		assertEquals(expected, result);
	}
	
	@Test
	public void testSub8() {
		BigInteger b1 = new BigInteger("857");
		BigInteger b2 = new BigInteger("857");
		BigInteger b3 = b1.sub(b2);
		String result = b3.toString();
		String expected = "0";
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testAdd1() {
		BigInteger b0 = new BigInteger("1357");
		BigInteger b1 = new BigInteger("2468");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "3825";
		assertEquals(expected, result);
	}

	@Test
	public void testAdd2() {
		BigInteger b0 = new BigInteger("8357");
		BigInteger b1 = new BigInteger("7468");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "15825";
		assertEquals(expected, result);
	}

	@Test
	public void testAdd3() {
		BigInteger b0 = new BigInteger("8357");
		BigInteger b1 = new BigInteger("68");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "8425";
		assertEquals(expected, result);
	}

	@Test
	public void testAdd4() {
		BigInteger b0 = new BigInteger("57");
		BigInteger b1 = new BigInteger("7468");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "7525";
		assertEquals(expected, result);
	}

	@Test
	public void testAdd5() {
		BigInteger b0 = new BigInteger("8357");
		BigInteger b1 = new BigInteger("-7468");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "889";
		assertEquals(expected, result);
	}
	
	
	@Test
	public void testAdd6() {
		BigInteger b0 = new BigInteger("-8357");
		BigInteger b1 = new BigInteger("7468");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "-889";
		assertEquals(expected, result);
	}
	
	@Test
	public void testAdd7() {
		BigInteger b0 = new BigInteger("123456789012345678901234567890");
		BigInteger b1 = new BigInteger("10");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "123456789012345678901234567900";
		assertEquals(expected, result);
	}
	
	@Test
	public void testAdd8() {
		BigInteger b0 = new BigInteger("12345678901234567890");
		BigInteger b1 = new BigInteger("-12345678901234567890");
		BigInteger b3 = b1.add(b0);
		String result = b3.toString();
		String expected = "0";
		assertEquals(expected, result);
	}
	
	@Test
	public void testCompareTo1() {
		BigInteger b0 = new BigInteger("123456789012345678901234567890");
		BigInteger b1 = new BigInteger("123456789012345678901234567890");
		int result = b0.compareTo(b1);
		int expected = 0;
		assertEquals(expected, result);
	}
	@Test
	public void testCompareTo2() {
		BigInteger b0 = new BigInteger("+123456789012345678901234567890");
		BigInteger b1 = new BigInteger("-123456789012345678901234567890");
		int result = b0.compareTo(b1);
		int expected = 1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testCompareTo3() {
		BigInteger b0 = new BigInteger("-123456789012345678901234567890");
		BigInteger b1 = new BigInteger("+123456789012345678901234567890");
		int result = b0.compareTo(b1);
		int expected = -1;
		assertEquals(expected, result);
	}
	
	@Test
	public void testEquals1() {
		BigInteger b0 = new BigInteger("123456789012345678901234567890");
		BigInteger b1 = new BigInteger("123456789012345678901234567890");
		boolean result = b0.equals(b1);
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test
	public void testIsZero1() {
		BigInteger b0 = new BigInteger("123456789012345678901234567890");
		BigInteger b1 = new BigInteger("123456789012345678901234567890");
		BigInteger b2 = b1.sub(b0);
		boolean result = b2.isZero();
		boolean expected = true;
		assertEquals(expected, result);
	}
	
	@Test
	public void testIsZero2() {
		BigInteger b0 = new BigInteger();
		boolean result = b0.isZero();
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	public void testtoArray1() {
		BigInteger b0 = new BigInteger("4567");
		int[] result = b0.toArray();
		int[] expected = {4,5,6,7};
		assertArrayEquals(expected, result);
	}
}



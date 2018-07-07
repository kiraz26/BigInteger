/**
 * Java's primitive data types int and long can represent the numbers 
 * in the following range. 
 * 
 * 			Integer: (-2147483648, 2147483647)
 * 			Long Integer: (-9223372036854775808, 9223372036854775807)
 *
 * We want to represent numbers that larger than 9223372036854775807. 
 * One idea is to use an array to store each digit of the big number. 
 * For example: 9223372036854775807 is stored in an array as 
 * [9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7]. 
 * 
 * 
 * In this project, you will implement the BigInteger class, which can 
 * store any size integer and perform basic arithmetic operations on the 
 * number. 
 */
package biginteger;

import java.util.Arrays;
import java.util.Collections;

public class BigInteger {

	private static final boolean POSITIVE = true;
	private static final boolean NEGATIVE = false;

	/**
	 * // this array stores the number. Each digit of the number is an element of
	 * the array
	 */
	private final int[] number;
	/**
	 * sign of this BigInteger. POSITIVE or NEGATIVE
	 */
	private final boolean sign;

	/**
	 * Default constructor, creates a BigInteger object whose value is 0. and whose
	 * sign is positive
	 * 
	 * This constructor will assign sign of the BigInteger and will assign
	 * BigInteger array called number to 0
	 */
	public BigInteger() {
		// TODO
		// replace assignments for number and sign with accordance to constructor
		// description
		number = new int[1];
		number[0] = 0;
		sign = POSITIVE;
	}

	/**
	 * Constructor, creates a BigInteger object with given sign and given array of
	 * numbers
	 * 
	 * @param sign
	 *            of a number
	 * @param array
	 *            of integers This constructor will assign sign of the BigInteger
	 *            and will copy all elements of the given array into BigInteger
	 *            array called number
	 */
	public BigInteger(boolean sign, int[] val) {
		// TODO
		// replace assignments for number and sign with accordance to constructor
		// description
		number = Arrays.copyOf(val, val.length);
		// number = new int[val.length]; // another solution !!!!!!!!!!!!!
		// for (int i = 0; i < val.length; i++) {
		// number[i]=val[i];
		// }

		this.sign = sign;
	}

	/**
	 * Create a BigInteger object using the number given as string. If the string
	 * starts with "-", it indicates, the number is negative. in this case assign
	 * sign to negative and store all numbers from a String in number array If the
	 * string starts with "+", or a digit, the number is positive. in this case
	 * assign sign to positive and store all numbers from a String in number array
	 * If the string is null or empty, the number is zero. zero is a positive
	 * number. in this case assign sign to positive and store 0 in number array If
	 * string contains non-digit characters, throw IllegalArgumentException in this
	 * case use the following syntax to throw an exception: throw new
	 * IllegalArgumentException();
	 * 
	 * 
	 * 
	 * @param n:
	 *            the number in string format. For example: BigInteger b1 = new
	 *            BigInteger("1234567890"); b1 is a BigInteger with value of
	 *            1234567890 stored in number array BigInteger b2 = new
	 *            BigInteger("-1234567"); b1 is a BigInteger with value of -1234567
	 *            stored in number array BigInteger b3 = new BigInteger("+123"); b3
	 *            is a BigInteger with value of +123 stored in number array
	 *            BigInteger b3 = new BigInteger("+123xyz"); throw
	 *            IllegalArgumentException
	 */
	public BigInteger(String strNumber) {
		// this(); // use to call the default constructor
		// TODO
		// replace assignments for number and sign with accordance to constructor
		// description
		if (strNumber.isEmpty() || strNumber == null) {
			number = new int[1];
			number[0] = 0;
			sign = POSITIVE;
			return;
		}
		int startIndex = 0;
		if (strNumber.charAt(0) == '-') {
			sign = NEGATIVE;
			startIndex++;
		} else if (strNumber.charAt(0) == '+') {
			sign = POSITIVE;
			startIndex++;
		} else {
			sign = POSITIVE;
		}
		// set number array size
		number = new int[strNumber.length() - startIndex];
		for (int i = startIndex; i < strNumber.length(); i++) {
			char ch = strNumber.charAt(i);
			if (!Character.isDigit(ch)) {
				throw new IllegalArgumentException();
			}
			// convert char to int
			number[i - startIndex] = Integer.parseInt(String.valueOf(ch));
		}

	}

	/**
	 * Create a BigInteger object using another another BigInteger. This constructor
	 * will take another BigInteger as a parameter and will copy all the values into
	 * this BigInteger and assign the sign
	 * 
	 * @param another:
	 *            BigInteger object BigInteger b = new BigInteger("-1234567890")
	 * 
	 *            Create a new BigInteger object using b BigInteger b2 = new
	 *            BigInteger(b)
	 */
	public BigInteger(BigInteger another) {
		// TODO
		// replace assignments for number and sign with accordance to constructor
		// description
		this.number = Arrays.copyOf(another.number, another.number.length);
		this.sign = another.sign;
	}

	/**
	 * Adds two BigIntegers, and creates a new BigInteger with the result of the
	 * addition
	 * 
	 * IMPORTANT: Pay attention to the integer sign and length When two positive
	 * values are added, the result is positive (2+2=4) When one positive and one
	 * negative numbers are added, the result can be negative (-4 + 2 = -2) or
	 * positive (-2 + 3 = 1) When two negative values are added, the result is
	 * negative (-2 + -2 = -4) When both numbers are zeroes, the result is zero as
	 * well
	 * 
	 * Two add two big integers, we cad add each digit at the same index from the
	 * two arrays. For example: a:[1,2,3,4] b:[5,6,7,8] a+b is [6,9,1,2]
	 * 
	 * @param b:
	 *            BigInteger to be added to this BigInteger Object
	 * @return: a new BigInteger object, whose value is the sum of this and b, two
	 *          BigInteger objects
	 */
	public BigInteger add(BigInteger b) {
		// TO DO
		// Lets first find out larger bigInteger
		BigInteger smaller = null;
		BigInteger larger = null;
		if (this.length() > b.length()) {
			smaller = b;
			larger = this;
		} else if (this.length() < b.length()) {
			smaller = this;
			larger = b;
		} else {
			if (this.number[0] > b.number[0]) {
				smaller = b;
				larger = this;
			} else {
				smaller = this;
				larger = b;
			}
		}
		int[] temp = new int[larger.length()];
		int indexTemp=temp.length-1;
		int carry=0;
		// loop through each index and add values until smaller one
		// reverse the array looping and adding for proper calculation
		//below code is only handing when signs of both BigIntegers are same
		if(this.sign==sign) {
		for (int index1 = smaller.length() - 1, index2 = larger.length() - 1; index1 >= 0; index1--, index2--) {
			
			int num = smaller.number[index1] + larger.number[index2]+carry;
			if(num>=10) {
				num-=10;
				carry=1;
			}else {
				carry = 0;
			}
			//add the result to temp array
			temp[indexTemp--] = num ;
		}
		for(int i = larger.length()-smaller.length()-1; i>=0; i--) {
			int num =larger.number[i]+carry;
			if(num>=10) {
				num-=10;
				carry=1;
			}else {
				carry = 0;
			}
			temp[indexTemp--] = num ;
		}
			
		}else if(this.sign ^ b.sign) {
			//TODO handle different signs
		}
		//increase the size of array if there is still a number to add
		if(carry == 0) {
			return new BigInteger(this.sign, temp);
		}else {
			temp = Arrays.copyOf(temp, temp.length+1);
			temp[0] =carry;
			return new BigInteger(this.sign, temp);
		}
		
//		System.out.println(Arrays.toString(temp));
		
	}

	/**
	 * Subtracts BigInteger b from this BigInteger, and creates a new BigInteger
	 * with the result of the subtraction.
	 * 
	 * @param b:
	 *            BigInteger to be subtracted from this BigInteger Object
	 * @return: a new BigInteger object
	 */
	public BigInteger sub(BigInteger b) {
		// TODO
		BigInteger result = new BigInteger(!b.sign, b.number);
		return this.add(result);
	}

	/**
	 * Returns a BigInteger whose value is (this % b).
	 * 
	 * @param b:
	 *            BigInteger object, by which this BigInteger is to be divided, and
	 *            the remainder computed.
	 * @return: this % b Throws: java.lang.ArithmeticException if b's value is zero
	 */
	public BigInteger remainder(BigInteger b) {
		// TODO
		return null;
	}

	/**
	 * Compares this BigInteger with the specified BigInteger.
	 * 
	 * @param b:
	 *            BigInteger to which this BigInteger is to be compared.
	 * @return: -1, 0 or 1 as this BigInteger is numerically less than, equal to, or
	 *          greater than b
	 * 
	 */
	public int compareTo(BigInteger b) {
		// TODO
		return 0;
	}

	/**
	 * Returns an int array containing this BigInteger. The array will contain each
	 * digit of this BigInteger as an element
	 * 
	 * @return: an int array containing this BigInteger, ignore the sign
	 */
	public int[] toArray() {
		// TODO

		return null;
	}

	/**
	 * Check if the BigInteger is zero
	 * 
	 * @return true if BigInteger value is zero. False otherwise
	 */
	public boolean isZero() {
		// TODO
		if (number.length == 1 && number[0] == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the length of this BigInteger. length is the number of digits in a
	 * BigInteger
	 * 
	 * @return: length of this integer
	 */
	public int length() {
		// TODO
		return number.length;
	}

	/**
	 * Returns the sign of this BigInteger.
	 * 
	 * @return: sign of this integer
	 */
	public boolean sign() {
		return sign;
	}

	/**
	 * returns the the BigInteger in string format. If the number is negative,
	 * return string must start with a "-"
	 * 
	 * @return BigInteger in a String format
	 */
	@Override
	public String toString() {
		// TODO
		String result = "";

		for (int n : number) {
			result += n;
		}
		if (sign == NEGATIVE) {
			result = "-" + result;
		}
		return result;

	}

}

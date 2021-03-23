/**
 * 2021.03.20
 * @author Joy
 * 01-1 알고리즘이란? (~25p)
 */

public class Q2 {
	private static int min(int a, int b, int c) {
		int min = a;
		if (b < min) 
			min = b;
		if (c < min)
			min = c;
		return min;
	}

	public static void main(String args[]) {
		System.out.println("min(1,2,3) = " + min(1,2,3));
	}
}

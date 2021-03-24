/**
 * 2021.03.20
 * @author Joy
 */

public class Q3 {
	private static int min(int a, int b, int c, int d) {
		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		if (d < min)
			min = d;
		return min;
	}


	public static void main(String args[]) {
		System.out.println("min(1,2,-3,4) = " + min(1,2,-3,4));
	}
}

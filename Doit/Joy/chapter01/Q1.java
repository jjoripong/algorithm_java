
/**
 * 2021.03.20
 * @author Joy
 */

public class Q1 {

	private static int max(int a, int b, int c, int d) {
		int max = a;
		if (b > max) 
			max = b;
		if (c > max)
			max = c;
		if (d > max)
			max = d;
		return max;
	}

	
	public static void main(String args[]) {
		System.out.println("max(1,2,3,4) = " + max(1,2,3,4));
	}
}

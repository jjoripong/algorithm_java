
/**
 * 2021.03.21
 * @author Joy
 */

public class Q8 extends Common{

	private static void q8(int n) {
		System.out.println("start q8");

		int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0); 
		
		System.out.println("result: " + sum);
	}

	public static void main(String args[]) {
		int n = inputNumber();
		q8(n);
	}
}

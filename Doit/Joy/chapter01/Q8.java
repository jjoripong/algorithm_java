
/**
 * 2021.03.21
 * @author Joy
 * 01-2 ¹Ýº¹¹® (~38p)
 */

public class Q8 extends Common{

	private static void q8(int n) {
		System.out.println("start q8");

		int i = 1;
		int sum = 0;
		int mid = n/2;
		
		while(i <= mid) {
			sum += (1 + n);
			i++;
		}
		
		System.out.println("result: " + sum);
	}

	public static void main(String args[]) {
		int n = inputNumber();
		q8(n);
	}
}

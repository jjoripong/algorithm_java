
/**
 * 2021.03.21
 * @author Joy
 */

public class Q7 extends Common{

	private static void q7(int n) {		
		System.out.println("start q7");

		int sum = 0;
		int i = 1;
		
		while(i <= n) {
			System.out.print(i);
			if(i < n) System.out.print(" + ");
			sum += i;
			i++;
		}
		
		System.out.println("= " + sum);
	}

	public static void main(String args[]) {
		int n = inputNumber();
		q7(n);
	}
}

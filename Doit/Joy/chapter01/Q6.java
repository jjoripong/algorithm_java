
/**
 * 2021.03.21
 * @author Joy
 */

public class Q6 extends Common{
	
	private static void sumWhile(int n) {		
		System.out.println("start sumWhile()");

		int sum = 0;
		int i  = 1;

		while(i <= n) {
			sum += 1;
			i++;
		}
		System.out.println("n: "+ n + " i: " + i);
	}
	
	public static void main(String args[]) {
		int n = inputNumber();
		sumWhile(n);
	}


}

/**
 * 2021.03.21
 * @author Joy
 */

public class Q14 {
	private static void q14(int n) {
		for (int i=0; i< n; i++) {
			for (int k=0; k < n; k++) {
				System.out.print("*");				
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		q14(5);
	}
}

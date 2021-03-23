/**
 * 2021.03.22
 * @author Joy
 * 01-2 �ݺ��� (~38p)
 */

public class Q16 {
	public static void spira(int n) {
		// ���� 2n-1, ���� n
	    // 00100 212 0001000  3 1 3 n-1
	    // 01110 131 0011100  2 3 2
	    // 11111 050 0111110  1 5 1
	    //           1111111  0 7 0
		for (int i=1; i <= n; i++) {
	        for(int blank= 1; blank <= n-i; blank++) {
	            System.out.print(" ");
	        }
	        for (int pira=1; pira <= 2*i-1; pira++) {
	            System.out.print("*");
	        }
	        System.out.println();
	    }
	}
	 
	public void main(String args[]) {
		spira(10);
	}
}

/**
 * 2021.03.21
 * @author Joy
 */

public class Q12 {

	public static void q12() {
		System.out.print("   |");
		for(int i=1; i<=9; i++) {
			System.out.print("  " + i);
		}
		System.out.println();
		System.out.print("---+");
		
		for(int i=1; i<=9; i++)
			System.out.print("---");
		System.out.println(" ");
		
		for(int i=1; i<=9; i++) {
			System.out.print(" "+ i + " |");
			for (int n=1; n<=9; n++) {
				int result = i*n;
				String sr = Integer.toString(result);
				if (sr.length() == 1) System.out.print("  " + result);
				else System.out.print(" "+result);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		q12();
	}
}

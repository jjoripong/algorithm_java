/**
 * 2021.03.22
 * @author Joy
 */

public class Q17 {

    public static void npira(int n) {
        // 001
        // 0222
        // 33333
        int i,j;
        for (i=1; i <= n; i++) {
            // 공백 출력
            for (j=1; j <= n-1; j++) {
                System.out.print(" ");
            }
            // 숫자 출력
            for (j=1; j<= 2*i-1; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

	public void main(String args[]) {
		spira(10);
	}

}

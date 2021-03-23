/**
 * 2021.03.22
 * @author Joy
 * 01-2 �ݺ��� (~38p)
 */

public class Q15 {
	private static void triangleLB(int n) {
        System.out.println("tirangleLB start");
        int i, star;
        for (i=1; i<=n; i++) {
            for (star=1; star <= i; star++) 
                System.out.printf("*");
            System.out.println();
        }
    }

    private static void triangleLU(int n) {
        System.out.println("tirangleLU start");
        int i, star;

        for (i=n; i>=1; i--) {
            for (star=i; star>=1; star--)
                System.out.printf("*");
            System.out.println();
        }
    }

    private static void triangleRU(int n) {
        System.out.println("tirangleRU start");
        /**
         * n = 3
         * i = 1 2 3 (int i = 1 i<= n; i++)
         * blank = 0 1 2 (if (i != 1) { int blank = 1; blank < i; blank++)
         * star = 3 2 1 (int star = n-i+1; star >= 1; star--)
         */
        int i, j;
        for (i=1; i<=n; i++) {
            if (i != 1) {
                for (j=1; j < i; j++) {
                    System.out.printf(" ");
                }
            }
            for (jr= 1; j <= n-i+1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }


    private static void triangleRB(int n) {
        System.out.println("tirangleRB start");
        for (int i = 1; i <= n; i++) {
            for (int blank = 1; blank <= n-i; blank++) {
                System.out.printf(" ");
            }
            for (int star = 1; star <= i; star++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    
	public static void main(String args[]) {
		triangleLB(5);
		triangleLU(5);
		triangleRU(5);
		triangleRB(5);
	}

    
}

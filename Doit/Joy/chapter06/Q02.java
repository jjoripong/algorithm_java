import java.util.Scanner;

public class Q02 {	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	// a[idx1]와 a[idx2]의 값을 바꿉니다. 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; 
		a[idx1] = a[idx2]; 
		a[idx2] = t;
	}

	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
        int comparison = 0;
        int swap = 0;

		for (int i = 0; i < n - 1; i++) {
            comparison++;
            System.out.printf("\n패스%d:\n", i+1);

            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n; m++) {
                    System.out.printf("%d ",a[m]);

                    if (a[m] == a[j-1]) {
                        if (a[j - 1] > a[j]) System.out.printf("+");
                        else System.out.printf("-");   
                    }     
                }
                System.out.println();

                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    swap++;
                }
            }
                    for (int m = 0; m < n; m++) {
                System.out.printf("%d ",a[m]);         
            }
        }

        System.out.printf("비교를 %d회 했습니다.\n", comparison);
        System.out.printf("교환을 %d회 했습니다.\n", swap);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬(버전 1)");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);				// 배열 x를 버블 정렬합니다.

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}

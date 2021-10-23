import java.util.Scanner;

public class Q04 {
    	// 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}

	// 버블 정렬(버전 3)
	static void bubbleSort(int[] a, int n) {
        int comparison = 0;
        int swap = 0;
		int k = 0;								// a[k]보다 앞쪽은 정렬을 마친 상태
		
        while (k < n - 1) {
			int last = n - 1;					// 마지막으로 요소를 교환한 위치
            System.out.printf("\n패스%d:\n", k+1);

			for (int j = n - 1; j > k; j--) {
                comparison++;

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
					last = j;
                    swap++;
				}
            }

            k = last;
            for (int m = 0; m < n; m++) {
                System.out.printf("%d ",a[m]);         
            }
		}

        System.out.printf("\n비교를 %d회 했습니다.\n", comparison);
        System.out.printf("교환을 %d회 했습니다.\n", swap);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("버블 정렬(버전 3)");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);				// 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}

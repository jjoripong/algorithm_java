import java.util.Scanner;

/**
 * 셸 정렬
 * 전체 리스트를 작은 부분 리스트로 나누어 삽입 정렬 진행
 *  */ 

public class Q0902 {

    // ver2. gap = …, 40, 13, 4, 1
    public static int shellSort(int a[], int n) {
        int gap = n / 2;
        int cnt = 0;

        // 초기 값 구하기 n /9를 넘지 않는 것이 좋다
        for (gap = 1; gap < n / 9; gap = gap * 3 + 1)
            ;

        for (; gap > 0; gap /= 3) {  // 간격 만들기

            for (int i = gap; i < n; i++) { // 부분 리스트 만들기
                int key = a[i];

                int j;
                for(j = i-gap; j >= 0 && a[j] > key; j -= gap) { // 삽입 정렬 실행
                    System.out.printf("a[%d] = %d | ", j+gap, a[j]);

                    a[j + gap] = a[j];
                    cnt++;
                    System.out.printf("cnt: %d\n",cnt);
                }

                System.out.printf("a[%d] = %d | ", j+gap, key);
                a[j + gap] = key;
                cnt++;
                System.out.printf("cnt: %d\n",cnt);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬(버전 1)");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		int cnt = shellSort(x, nx);			// 배열 x를 셸 정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);

        System.out.printf("이동 수: %d", cnt);

	}
}

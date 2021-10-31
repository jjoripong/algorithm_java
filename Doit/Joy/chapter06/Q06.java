import java.util.Scanner;

// 선택 정렬 탐색 과정 출력
public class Q06 {
    
    public static void selectionSort(int a[], int n) {
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (j == i) System.out.printf("* ");
                else if (min == j) System.out.printf("+ ");
                else System.out.printf("  ");
            }

            System.out.println("");

            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", a[j]);
            }

            System.out.println("");
            swap(a, i, min);
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; 
        a[idx1] = a[idx2]; 
        a[idx2] = t;
	}

    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("단순 선택 정렬");
        System.out.println("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("오름차순으로 정렬완료");
        printArray(x, nx);
    }
}

/**
 * 결과
 * 요솟수: 
7
x[0]：6
x[1]：4
x[2]：8
x[3]：3
x[4]：1
x[5]：9
x[6]：7
*       +     
6 4 8 3 1 9 7
  *   +
1 4 8 3 6 9 7
    * +
1 3 8 4 6 9 7
      * +
1 3 4 8 6 9 7 
        *   +
1 3 4 6 8 9 7
          * +
1 3 4 6 7 9 8 
오름차순으로 정렬완료
x[0]=1
x[1]=3
x[2]=4
x[3]=6
x[4]=7
x[5]=8
x[6]=9
 */
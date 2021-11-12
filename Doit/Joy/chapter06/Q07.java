import java.util.Scanner;

/** 
 * 삽입 정렬 개선 : 보초 사용
 * a[0]에 항상 제일 작은 요소가 있다고 가정하고 출력은 a[1] ~ a[end]
 * 보초값을 주어지는 범위에 따라 설정해야 함
 * */ 
public class Q07 {
    
    public static void insertionSort(int a[], int n) {
        for (int i = 2; i < n; i++) {   // 2~n-1
            int j;
            int key = a[0] = a[i];
            for (j = i; key < a[j-1]; j--) {  
                a[j] = a[j-1];
            }
            a[j] = key;
        }
    }

    public static void printArray(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("단순 삽입 정렬");
        System.out.println("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx+1];

        // x[0] = -1;

        for (int i = 1; i < nx+1; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        insertionSort(x, nx+1);

        System.out.println("오름차순으로 정렬완료");
        for (int i = 1; i < nx+1; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}

/**
 * 결과
 * 단순 삽입 정렬
요솟수: 
4
x[1]：3
x[2]：5
x[3]：4
x[4]：1
오름차순으로 정렬완료
x[1]=1
x[2]=3
x[3]=4
x[4]=5
 */
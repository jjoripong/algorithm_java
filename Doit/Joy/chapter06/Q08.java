import java.util.Scanner;

/**
 * 이진 삽입 정렬
 * 이진 탐색 : 중앙값을 기준으로 탐색 범위 좁혀나가기
 * 이미 정렬된 부분에서 이진 탐색을 사용하여 값을 삽입할 위치를 찾는다
 */ 
public class Q08 {
    
    public static void insertionSort(int a[], int n) {
        int i, j, key, first, last, insertPosition;
        for (i = 1; i < n; ++i) {   // 1~n-1
            key = a[i];
            
            first = 0;
            last = i-1;
            
            insertPosition = binarySearch(a, first, last, key);   
            System.out.printf("삽입 위치: %d \n", insertPosition);

            for (j = i-1; j >= insertPosition; --j) {  
                // 삽입을 위해 오른쪽으로 한칸씩 뒤로 밀기
                a[j+1] = a[j]; 
            }
            a[insertPosition] = key;
        }
    }

    private	static int binarySearch(int a[], int first, int last, int key) {
        int mid;
        do {
            mid = (first + last) / 2;
            if (key == a[mid]) break;
            else if (key > a[mid]) 
                first = mid + 1;
            else 
                last = mid - 1;
        } while(first <= last);

        return first;
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
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = sc.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름차순으로 정렬완료");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}

/**
 * 결과
 */
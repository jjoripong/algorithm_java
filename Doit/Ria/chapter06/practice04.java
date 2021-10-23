import java.util.Arrays;
import java.util.Scanner;
/*
Date : 2021-10-23
Q4 : 개개선된 버블 정렬 비교, 교환 과정 출력
비교 후 교환 O: +
비교 후 교환 X: -
*/
public class practice04 {
    static void printArray(int[] a, int start, int end){
        for(int i = start; i < end; i ++){
            System.out.printf("%3d",a[i]);
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //개개선된 버블 정렬 (마지막으로 교환한 위치 기억)
    static void bubbleSort(int[] a, int n) {
        int exchange = 0;
        int compare = 0;
        int k = 0; // 마지막 교환 위치 저장
        int i = 0; //패스
        while (k < n-1){
            int last = n-1; //교환 위치
            System.out.println("패스"+i+":");
            for (int j = n - 1; j > k; j--) {
                printArray(a,0,j);
                if (a[j - 1] > a[j]) {
                    System.out.printf("  +");
                    printArray(a,j,n);
                    swap(a, j - 1, j);
                    last = j;
                    exchange++;
                } else {
                    System.out.printf("  -");
                    printArray(a,j,n);
                }
                compare++;
                System.out.println("");
            }
            k = last;
            i++;
        }
        System.out.println("비교 횟수 : "+compare);
        System.out.println("교환 횟수 : "+exchange);
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8};

        bubbleSort(x, x.length);
    }
}

/*
print:
패스0:
  6  4  3  7  1  9  +  8
  6  4  3  7  1  -  8  9
  6  4  3  7  +  1  8  9
  6  4  3  +  1  7  8  9
  6  4  +  1  3  7  8  9
  6  +  1  4  3  7  8  9
패스1:
  1  6  4  3  7  8  -  9
  1  6  4  3  7  -  8  9
  1  6  4  3  -  7  8  9
  1  6  4  +  3  7  8  9
  1  6  +  3  4  7  8  9
패스2:
  1  3  6  4  7  8  -  9
  1  3  6  4  7  -  8  9
  1  3  6  4  -  7  8  9
  1  3  6  +  4  7  8  9
패스3:
  1  3  4  6  7  8  -  9
  1  3  4  6  7  -  8  9
  1  3  4  6  -  7  8  9
비교 횟수 : 18
교환 횟수 : 8
*/
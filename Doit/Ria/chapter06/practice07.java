/*
Date : 2021-10-31
Q7 : 삽입 정렬 보초 사용
*/
public class practice07 {
    static void printArray(int[] a, int start, int end){
        for(int i = start; i < end; i ++){
            System.out.printf("%3d",a[i]);
        }
        System.out.println();
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i; j > 1 && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{-1,6,4,8,3,1,9,7};

        insertionSort(x, x.length);

        System.out.println("삽입 정렬 - 보초 사용:");
        printArray(x,1,x.length);
    }
}

/*
print:
삽입 정렬 - 보초 사용:
  1  3  4  6  7  8  9
*/
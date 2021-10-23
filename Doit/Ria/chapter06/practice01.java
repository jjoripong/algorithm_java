/*
Date : 2021-10-23
Q1 : 버블 정렬 처음 부터 비교, 교환 수행
*/
public class practice01 {
    static void printArray(int[] a){
        for(int value : a){
            System.out.printf("%3d",value);
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 처음 부터 비교, 교환
    static void bubbleSort(int[] a, int n) {
        for (int i = n-1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (a[j] > a[j+1])
                    swap(a, j, j+1);
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8};

        bubbleSort(x, x.length);

        System.out.println("버블정렬:");
        printArray(x);
    }
}

/*
print:
버블정렬:
  1  3  4  6  7  8  9
*/
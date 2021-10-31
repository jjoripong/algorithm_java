/*
Date : 2021-10-31
Q8 : 삽입 정렬 - 이진 검색 사용
*/
public class practice08 {
    static void printArray(int[] a, int start, int end){
        for(int i = start; i < end; i ++){
            System.out.printf("%3d",a[i]);
        }
        System.out.println();
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];
            int loc = binSearch(a,i,tmp);
            for (j = i; j > loc ; j--)
                a[j] = a[j - 1];
            a[loc] = tmp;
        }
    }

    static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                break;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return pr + 1;
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,8,3,1,9,7};

        insertionSort(x, x.length);

        System.out.println("삽입 정렬 - 이진 검색 사용:");
        printArray(x,0,x.length);
    }
}

/*
print:
삽입 정렬 - 이진 검색 사용:
  1  3  4  6  7  8  9
*/
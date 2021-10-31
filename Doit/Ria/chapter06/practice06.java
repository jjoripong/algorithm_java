/*
Date : 2021-10-31
Q6 : 선택 정렬 과정 출력
정렬하지 않은 부분의 첫번째 요소: *
가장 작은 값의 요소소 +
*/
public class practice06 {
    static void printArray(int[] a){
        for(int i = 0; i < a.length; i ++){
            System.out.printf("%3d",a[i]);
        }
        System.out.println();
    }

    static void printMark(int[] a, int star, int plus){
        for(int i = 0; i < a.length; i ++){
            if(i == star)
                System.out.printf("%3s","*");
            else if (i == plus)
                System.out.printf("%3s","+");
            else
                System.out.printf("%3s"," ");
        }
        System.out.println();
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            printMark(a,i,min);
            printArray(a);
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,8,3,1,9,7};

        selectionSort(x, x.length);

        System.out.println("선텍 정렬:");
        printArray(x);
    }
}

/*
print:
  *           +      
  6  4  8  3  1  9  7
     *     +         
  1  4  8  3  6  9  7
        *  +         
  1  3  8  4  6  9  7
           *  +      
  1  3  4  8  6  9  7
              *     +
  1  3  4  6  8  9  7
                 *  +
  1  3  4  6  7  9  8
선텍 정렬:
  1  3  4  6  7  8  9
*/
import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System. in);

        System
            .out
            .println("단순교환정렬(버블정렬)");
        System
            .out
            .print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System
                .out
                .print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx); // 배열 x를 단순교환정렬

        System
            .out
            .println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) 
            System
                .out
                .println("x[" + i + "]＝" + x[i]);
        }
    
    static void bubbleSort(int[] a, int n) {
        int comparison = 0;
        int swap = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.printf("\n패스%d:\n", i+1);
            for (int j = 0; j < n-i-1; j++) { //탐색에서 마지막 요소 제외
                comparison++;

                for (int m = 0; m < n; m++) {
                    System.out.printf("%d ",a[m]);

                    if (a[m] == a[j]) {
                        if (a[j] > a[j+1]) System.out.printf("+");
                        else System.out.printf("-");   
                    }     
                }
                System.out.println();
                
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    swap++;
                } 
            }

            for (int m = 0; m < n; m++) {
                System.out.printf("%d ",a[m]);         
            }
        }

        System.out.printf("\n비교를 %d회 했습니다.\n", comparison);
        System.out.printf("교환을 %d회 했습니다.\n", swap);
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}

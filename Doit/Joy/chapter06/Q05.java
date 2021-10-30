import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System. in);

        System
            .out
            .println("칵테일정렬");
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

    
    public enum Direction{
        Left,
        Right
    };

    static void bubbleSort(int[] a, int n) {
        int comparison = 0;
        int swap = 0;
        Direction d = Direction.Left;
        int k = 0;

        while (k < n - 1) {
            int last = n - 1;		
            switch (d) {
            case Left: 
                System.out.println("<===");
                for (int j = n-1; j > k; j--) {
                    comparison++; 
                    if (a[j-1] > a[j]) {
                        swap(a, j-1, j);
                        swap++;
                    }
                }
                d = Direction.Right;
                 break;
            case Right: 
                System.out.println("===>");
                    for (int j = 0; j < n-k-1; j++) { 
                        comparison++; 
                        if (a[j] > a[j+1]) {
                            swap(a, j, j+1);
                            swap++;
                        }
                    }
                d = Direction.Left;
                break;
            default: break;
        } 

            k = last;

        for (int m = 0; m < n; m++) {
            System.out.print(a[m]);
        }

        System.out.println();    
    }
        
        System.out.printf("비교를 %d회 했습니다.\n", comparison);
        System.out.printf("교환을 %d회 했습니다.\n", swap);
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}

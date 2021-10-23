/*
Date : 2021-10-23
Q5 : 양방향 버블 정렬
- 홀수 번째 패스 : 가장 작은 요소 맨 앞으로 옮김
- 짝수 번째 패스 : 가장 큰 요소 맨 뒤로 옮김

Q5-1 : 양방향 버블 정렬 비교, 교환 과정 출력
비교 후 교환 O: +
비교 후 교환 X: -
*/
public class practice05 {
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

    //양방향 버블 정렬 과정 출력
    static void bubbleSortPrint(int[] a, int n) {
        int exchange = 0;
        int compare = 0;
        int minFix = 0; // 홀수 번째 마지막 교환 위치 저장
        int maxFix = n-1; // 짝수 번째 마지막 교환 위치 저장
        int i = 1; //패스
        while (minFix < maxFix){
            int last = n-1; //교환 위치
            System.out.println("패스"+i+":");
            if(i%2 == 1) {
                for (int j = maxFix; j > minFix; j--) {
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
                minFix = last;
            }
            else{
                for (int j = minFix; j < maxFix; j++){
                    printArray(a,0,j);
                    if (a[j] > a[j+1]){
                        System.out.printf("  +");
                        printArray(a,j,n);
                        swap(a, j, j+1);
                        last = j;
                        exchange++;
                    }else {
                        System.out.printf("  -");
                        printArray(a,j,n);
                    }
                    compare++;
                    System.out.println("");
                }
                maxFix = last;
            }
            i++;
        }
        System.out.println("비교 횟수 : "+compare);
        System.out.println("교환 횟수 : "+exchange);
    }
    
    //양방향 버블 정렬
    static void bubbleSort(int[] a, int n) {
        int minFix = 0; // 홀수 번째 마지막 교환 위치 저장
        int maxFix = n-1; // 짝수 번째 마지막 교환 위치 저장
        int i = 0; //패스
        while (minFix < maxFix){
            int last = n-1; //교환 위치
            if(i%2 == 1) {
                for (int j = maxFix; j > minFix; j--) {
                    if (a[j - 1] > a[j]) {
                        swap(a, j - 1, j);
                        last = j;
                    }
                }
                minFix = last;
            }
            else{
                for (int j = minFix; j < maxFix; j++){
                    if (a[j] > a[j+1]){
                        swap(a, j, j+1);
                        last = j;
                    }
                }
                maxFix = last;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8};

        bubbleSort(x, x.length);

        System.out.println("버블정렬:");
        printArray(x, 0, x.length);
    }
}

/*
print:
버블정렬:
  1  3  4  6  7  8  9
  
패스1:
  6  4  3  7  1  9  +  8
  6  4  3  7  1  -  8  9
  6  4  3  7  +  1  8  9
  6  4  3  +  1  7  8  9
  6  4  +  1  3  7  8  9
  6  +  1  4  3  7  8  9
패스2:
  1  +  6  4  3  7  8  9
  1  4  +  6  3  7  8  9
  1  4  3  -  6  7  8  9
  1  4  3  6  -  7  8  9
  1  4  3  6  7  -  8  9
패스3:
  1  4  +  3  6  7  8  9
비교 횟수 : 12
교환 횟수 : 8
*/
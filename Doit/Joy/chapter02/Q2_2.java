import java.util.Random;

public class Q2_2 {
	
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    static void printArray(int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("array[" + i + "]와 array[" + (a.length - 1 - i) + "]를 교환 합니다.");
            swap(a, i, a.length - i - 1);
            printArray(a);
        }
    }

    // Rand 는 0~n-1 까지 수 생성    
    //범위를 n 까지 하고 싶으면 +1 해줘야 한다
	public static void main(String args[]) {
        Random rand = new Random();
        int itemNum = rand.nextInt(20);
        int[] mArray = new int[itemNum];
        int i;

        // 배열 구성
        for (i = 0; i < mArray.length; i++) {
            mArray[i] = rand.nextInt(90);
        }

        printArray(mArray);
        reverse(mArray);
        System.out.println("정렬을 마쳤습니다.");
    }
}

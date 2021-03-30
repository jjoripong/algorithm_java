import java.util.Random;

public class Q2_4 {

	static void makeRandomArray(int[] a, int range) {
		System.out.println("랜덤 배열 생성");
		Random rand = new Random();
		
		for (int i=0; i < a.length; i++) {
			a[i] = rand.nextInt(range);
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	// b의 요소를 a에 복사
	// 크기가 같지 않은 경우..? 생각 x
	static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			System.out.print("before copy a: " + a[i] + " b: " + b[i] + "\n");
			a[i] = b[i];
			System.out.print("after copy a: " + a[i] + " b: " + b[i] + "\n");
		}
	}
	
	public static void main(String args[]) {
		int[] b = new int[10];
		makeRandomArray(b, 10);
		int[] a = new int[b.length];
		copy(a, b);
	}
}

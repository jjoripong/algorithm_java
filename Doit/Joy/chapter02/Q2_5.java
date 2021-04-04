import java.util.Random;

public class Q2_5 {

	static void makeRandomArray(int[] a, int range) {
		System.out.println("랜덤 배열 생성");
		Random rand = new Random();
		
		for (int i=0; i < a.length; i++) {
			a[i] = rand.nextInt(range);
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	
	static void rcopy(int[] a, int[] b) {
		for (int i=0; i < b.length; i++) {
			System.out.print("before copy a: " + a[i] + " b: " + b[b.length - i -1] + "\n");
			a[i] = b[b.length - i -1];
			System.out.print("after copy a: " + a[i] + " b: " + b[b.length - i -1] + "\n");
		}
	}
	
	public static void main(String args[]) {
		int[] b = new int[10];
		makeRandomArray(b, 10);
		int[] a = new int[b.length];
		rcopy(a, b);
	}
}

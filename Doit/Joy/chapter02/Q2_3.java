import java.util.Random;

public class Q2_3 {

	static int sumOf(int[] a) {
		int i, sum = 0;
		for (i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println("배열 합: " + sum);
		return sum;
	}
	
	static int[] makeRandomArray(int size) {
		System.out.println("랜덤 배열 생성");
		Random rand = new Random();
		int[] a = new int[size];
		
		for (int i=0; i < a.length; i++) {
			a[i] = rand.nextInt();
			System.out.print(a[i] + " ");
		}
		System.out.println();
		return a;
	}
	
	public static void main(String args[]) {
		sumOf(makeRandomArray(10));
	}
}

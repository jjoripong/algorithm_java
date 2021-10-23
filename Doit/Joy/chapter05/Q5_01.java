import java.util.Scanner;

// 재귀 메서드 사용하지 않고 factorial 메서드 작성하기
public class Q5_01 {

	static int factorial(int n) {
		int f = n;
		while(f > 1) {
			n *= --f;
			System.out.println(String.format("f: %d n: %d", f, n));
		}
		return n;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int x = stdIn.nextInt();
		
		System.out.println(String.format("%d의 팩토리얼은 %d 입니다.", x, factorial(x)));
	}
}

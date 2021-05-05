import java.util.Scanner;

public class Q5_02 {
	
	static int gcd(int x, int y) {
		while (y != 0) {
			int tmp = y;
			y = x % y;
			x = tmp;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("두 정수의 최대 공약수를 구합니다.");

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();
		System.out.print("정수를 입력하세요.：");
		int y = stdIn.nextInt();

		System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
	}}

import java.util.Scanner;
/*
Q2 : 유클리드 호제법으로 최대공약수 구하기를 재귀적으로 구현한 함수 -> 재귀 메서드 호출을 사용하지 않기로 변경
*/
public class practice02 {
	
//	static int gcd(int x, int y) {
//		if (y == 0)
//			return x;
//		else
//			return gcd(y, x % y);
//	}

	static int gcd(int x, int y) {
		while ( x % y != 0) {
			y = x % y;
		}
		return y;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("두 정수의 최대공약수를 구합니다.");

		System.out.print("정수를 입력하세요：");	int x = stdIn.nextInt();
		System.out.print("정수를 입력하세요：");	int y = stdIn.nextInt();

		System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
	}
}

/*
print:
두 정수의 최대공약수를 구합니다.
정수를 입력하세요：12
정수를 입력하세요：4
최대공약수는 4입니다.
두 정수의 최대공약수를 구합니다.
정수를 입력하세요：22
정수를 입력하세요：8
최대공약수는 2입니다.
*/
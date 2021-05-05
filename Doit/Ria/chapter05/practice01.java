import java.util.Scanner;
/*
Q1 : 팩토리얼을 재귀적으로 구현한 함수를 재귀 메서드 호출을 사용하지 않기
*/
public class practice01 {
	
//	static int factorial(int n) {
//		if (n > 0)
//			return n * factorial(n - 1);
//		else
//			return 1;
//	}
	
	static int factorial(int n) {
		int mul = n = n <= 0 ? 1 : n;
		while (n-1 > 0) {
			mul *= (n-1);
			n--;
		}
		return mul;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();

		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}
}

/*
print:
정수를 입력하세요.：3
3의 팩토리얼은 6입니다.

정수를 입력하세요.：0
0의 팩토리얼은 1입니다.
*/
import java.util.Scanner;
/*
Q2 : 유클리드 호제법으로 최대공약수 구하기를 재귀적으로 구현한 함수 -> 재귀 메서드 호출을 사용하지 않기로 변경
*/
public class practice03 {
	
//	static int gcd(int x, int y) {
//		if (y == 0)
//			return x;
//		else
//			return gcd(y, x % y);
//	}
	
	static int gcd(int a[]) {
		for(int i = 0; i < a.length-1 ; i++) {
			while ( i != a.length-1 && a[i]%a[i+1] != 0) {
				a[i+1] = a[i]%a[i+1];
			}
		}
		return a[a.length-1];
	}
	
	public static void main(String[] args) {
		System.out.println("배열의 최대공약수를 구합니다.");
		int a[] = new int[] {12,6,4};
		System.out.println("최대공약수는 " + gcd(a) + "입니다.");
	}
}

/*
print:
배열의 최대공약수를 구합니다.
최대공약수는 2입니다.
*/
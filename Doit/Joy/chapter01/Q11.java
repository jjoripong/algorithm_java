/**
 * 2021.03.21
 * @author Joy
 * 01-2 반복문 (~38p)
 */


import java.util.Scanner;

public class Q11 {
	public static void q11() {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주: ");
		
		Long n = stdIn.nextLong();

		while (n <= 0) {
			System.out.println("0보다 큰값을 입력하세요!");
			n = stdIn.nextLong();
		}
		
		stdIn.close();
		
		String sn = Long.toString(n);
		System.out.println("그 수는 " + sn.length() + "자리입니다.");
	}
	
	public static void main(String args[]) {
		q11();
	}

}

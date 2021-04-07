import java.util.Scanner;

public class Q2_6 {

	// 배열 앞쪽에 윗자리 넣기 -> reverse
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		
		for (int i=0; i < digits/2; i++) {
			char t = d[i];
			d[i] = d[digits -1 -i];
			d[digits-1-i] = t;
		}
		
		return digits;
	}
	
	// x를 r진수로 변환하여 배열 d에 추가
	static int cardConvRev(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		
		return digits;
	}
	
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int no, cd, dno, retry; // 정수, 기수, 자릿수, 재시도
		char[] cno = new char[32];
		
		System.out.println("10진수를 기수로 변환합니다.");
		do {
			do {
				System.out.println("음이 아닌 정수를 입력해주세요: ");
				no = stdIn.nextInt();
			} while (no < 0);
			
			do {
				System.out.println("몇 진수로 변환할까요? (2~32 사이 숫자를 입력해주세요): ");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 32);
			
			dno = cardConvRev(no, cd, cno);
			
			System.out.println("cardConRev" + cd + " 진수로는");
			for (int i = dno -1; i >= 0; i--) {
				System.out.print(cno[i]);
			}
			System.out.println();
			
			dno = cardConv(no, cd, cno);
			System.out.print("cardConRev: "+ cd + " 진수로는");
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}
			
			System.out.println("한 번 더 할까요? (1. 예 2. 아니오)");
			retry = stdIn.nextInt();
		} while (retry == 1);
		
		stdIn.close();
	}
}

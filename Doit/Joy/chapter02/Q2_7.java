import java.util.Scanner;

public class Q2_7 {

	// 배열 앞쪽에 윗자리 넣기 -> reverse
	static int cardConv(int x, int r, char[] d) {
        int n = ((Integer) x).toString().length(); // 변환 전의 자릿수
        int digits = 0; // 변환 뒤의 자릿수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%2d | %d \n", n, x);
        do {
            System.out.printf("   +");
            for (int i = 0; i < n + 2; i++)
                System.out.print('-');
            System.out.println();

            if (x / r != 0)
                System.out.printf("%2d | %d    … %d\n", n, x / r, x % r);
            else
                System.out.printf("     %d    … %d\n", n, x / r, x % r);
            d[digits++] = dchar.charAt(x % r); 
            x /= r;
        } while (x != 0);

        // reverse
        for (int i = 0; i < digits / 2; i++) { // d[0]~d[digits-1]
            char temp = d[i]; // 를 역순으로 정렬
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
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

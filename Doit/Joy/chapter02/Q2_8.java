import java.util.Scanner;

public class Q2_8 {

	// 2월 평년 28, 윤년 29
	static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 31, 29, 31,30, 31, 30, 31, 31, 30, 31, 30, 31 }
	};

	// 윤년: 4, 100으로 나누어 떨어지거나, 400으로 나누어 떨어지지 않는 수
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 == 0 || year % 400 != 0) ? 1 : 0;  
	}
	
	// y- 평년인지 윤년인지 판단값 0 또는 1, m- 전달 수만큼 +1 d- 그대로 +
	static int dayOfYear(int y, int m, int d) {		
	//		for (int i=1; i < m; i++) 
	//		d += mdays[isLeap(y)][i-1];
		while(--m > 0) {
			d += mdays[isLeap(y)][m-1];
		}
		return d;
	}
	
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		do {
			System.out.println("년: "); int year = stdIn.nextInt();
			System.out.println("월: "); int month = stdIn.nextInt();
			System.out.println("일: "); int day = stdIn.nextInt();

			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.println("계속 하시겠습니까? (1 예 / 2 아니오)");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
}

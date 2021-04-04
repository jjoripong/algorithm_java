import java.util.Date;
import java.util.Scanner;

public class YMD {

	private static int y;
	private static int m;
	private static int d;
	
	public YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	
	// 날짜로부터 n일 후 날짜 반환
	YMD after(int n) {
        YMD rtYmd = new YMD(y, m, d);
        //this : 입력 받은 값
        this.d += n;

        // 입력받은 d가 365일보다 크면 그해 일 수 로 나눠 주기
        int year = 365 + isLeap(this.y);
        while (this.d > year) {
            rtYmd.y += this.d / year;
            this.d = this.d % year;
        }
        // 입력받은 d가 m의 일 수보다 크면 12로 나눠 주기
        while (this.d > mdays[isLeap(this.y)][this.m-1]) {
            rtYmd.m += this.d / mdays[isLeap(this.y)][this.m-1];
            this.d = this.d % mdays[isLeap(this.y)][this.m-1];
        }
        rtYmd.d = this.d;

        return rtYmd;
	}
	
	// 날짜로부터 n일 전 날짜 반환
	YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return (after(-n));

        temp.d -= n;

        while (temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
	}
	
	// 2월 평년 28, 윤년 29
	static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 31, 29, 31,30, 31, 30, 31, 31, 30, 31, 30, 31 }
	};

	// 윤년: 4, 100으로 나누어 떨어지거나, 400으로 나누어 떨어지지 않는 수
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 == 0 || year % 400 != 0) ? 1 : 0;  
	}
	
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		do {
			System.out.println("년: "); int year = stdIn.nextInt();
			System.out.println("월: "); int month = stdIn.nextInt();
			System.out.println("일: "); int day = stdIn.nextInt();
			System.out.println("n: "); int n = stdIn.nextInt();
			YMD y = new YMD(year, month, day);
			
			YMD a = y.after(n);
			System.out.printf("%d일 후의 날짜는 %d년 %d월 %d일입니다.\n", n, a.y, a.m, a.d);
			YMD b = y.before(n);
			System.out.printf("%d일 전의 날짜는 %d년 %d월 %d일입니다.\n", n, b.y, b.m, b.d);
			
			System.out.println("계속 하시겠습니까? (1 예 / 2 아니오)");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
	
}

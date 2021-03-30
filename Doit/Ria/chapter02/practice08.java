import java.util.Scanner;

public class practice08 {
    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    //(윤년：1／평년：0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d) {
        while (--m>0){
            d += mdays[isLeap(y)][(m)-1];
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int retry;

        System.out.println("연내의 경과 일 수를 구합니다.");

        do {
            System.out.print("년：");
            int year = stdIn.nextInt();
            System.out.print("월：");
            int month = stdIn.nextInt();
            System.out.print("일：");
            int day = stdIn.nextInt();

            System.out.printf("연내 %d일째입니다.\n", dayOfYear(year, month, day));

            System.out.print("한번 더 할까요? (1.예/0.아니오)：");
            retry = stdIn.nextInt();
        } while (retry == 1);
        stdIn.close();
    }
}

/*
print:
연내의 경과 일 수를 구합니다.
년：2019
월：3
일：15
연내 74일째입니다.
한번 더 할까요? (1.예/0.아니오)：0
*/

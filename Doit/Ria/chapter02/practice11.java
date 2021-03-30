public class practice11 {

    static class YMD {
        int y;
        int m;
        int d;

        YMD(int year, int month, int day) {
            this.y 	= year;
            this.m = month;
            this.d = day;
        }

        YMD after(int n){

        }

        YMD befor(int n){

        }
    }

    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d) {
        int day = 0;
        while (m<=12){
            day += mdays[isLeap(y)][m-1];
            m++;
        }
        return day-d;
    }

    public static void main(String[] args) {

        YMD cTime = new YMD(2021,3,31);
    }
}

/*
print:
*/

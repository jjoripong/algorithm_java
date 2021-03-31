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
        	YMD aTime = new YMD(this.y,this.m,this.d);
        	int year = aTime.y;
        	aTime.y = y-(n/365);
        	int remDate = (n%365);
        	while(aTime.d - remDate <=0){
        		aTime.m--;
        		if(aTime.m == 0) {
        			aTime.m = 12;
        			year--;
        		}
        		remDate = (aTime.d - remDate)*-1;
        		aTime.d = mdays[isLeap(year)][aTime.m-1];
        	}        	
        	aTime.d -= remDate;
        	return aTime;
        }

		
		 YMD before(int n){
			 YMD bTime = new YMD(this.y,this.m,this.d);
			 int year = bTime.y;
			 int day = bTime.d;
			 bTime.y = y+(n/365);
			 int remDate = n; //3
			 
			 while(day+remDate > mdays[isLeap(year)][bTime.m-1]){
				//day = 31
				//if(day+remDate > mdays[isLeap(year)][bTime.m-1]) {
				 //System.out.println("remDate : "+remDate);
				if(mdays[isLeap(year)][bTime.m-1]== remDate) {
					 remDate = 0;
				}else {
					remDate -= (mdays[isLeap(year)][bTime.m-1]-day-1 < 0)? 1:mdays[isLeap(year)][bTime.m-1]-day-1;
				}
				//System.out.println("remDate : "+remDate);
					bTime.m++;
					if(bTime.m == 12) {
						bTime.m = 1;
						year++;
					}
					day = 1;
				//}
			 };
			 //System.out.println("day : "+day);
			 //System.out.println("remDate ff: "+remDate);
			 bTime.d = day+remDate;
			 //System.out.println("bTime.d : "+bTime.d);
			 return bTime;
		 }
		 
    }

    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        YMD cTime = new YMD(2021,3,31);
        
        YMD aTime = cTime.after(3);
        YMD aTime1 = cTime.after(31);
        YMD aTime2 = cTime.after(366);
        
        System.out.println("현재날짜 : "+cTime.y+"년 "+cTime.m+"월 "+cTime.d+"일\n");
        System.out.println("after 3 : "+aTime.y+"년 "+aTime.m+"월 "+aTime.d+"일");
        System.out.println("after 31 : "+aTime1.y+"년 "+aTime1.m+"월 "+aTime2.d+"일");
        System.out.println("after 366 : "+aTime2.y+"년 "+aTime2.m+"월 "+aTime2.d+"일");
        
        YMD bTime = cTime.before(3);
        YMD bTime1 = cTime.before(31);
        YMD bTime2 = cTime.before(365);
        
        System.out.println("before 3 : "+bTime.y+"년 "+bTime.m+"월 "+bTime.d+"일");
        System.out.println("before 31 : "+bTime1.y+"년 "+bTime1.m+"월 "+bTime1.d+"일");
        System.out.println("before 365 : "+bTime2.y+"년 "+bTime2.m+"월 "+bTime2.d+"일");
    }
}

/*
print:
현재날짜 : 2021년 3월 31일

after 3 : 2021년 3월 28일
after 31 : 2021년 2월 30일
after 366 : 2020년 3월 30일
before 3 : 2021년 4월 3일
before 31 : 2021년 4월 1일
before 365 : 2022년 5월 25일
*/

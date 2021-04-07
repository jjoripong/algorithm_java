import java.util.Scanner;

public class practice07 {

    static int cardConvR(int x, int r, char[] d){
        int digits = 0;
        int nmj = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%2d| %5d",r,x);
        System.out.println("\n  +------");
        do {
            d[digits++] = dchar.charAt(x%r);
            nmj =x%r;
            x /= r;
            if(x != 0){
                System.out.printf("%2d| %5d ···%2d",r,x,nmj);
                System.out.println("\n  +------");
            }else{
                System.out.printf("    %5d ···%2d",x,nmj);
                System.out.println(" ");
            }

        }while (x !=0);
        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int no; //변환하는 정수
        int kisu; //기수
        int dno; //변환 후 자릿수
        int retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변화합니다.");
        do{
            do{
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            }while (no<0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                kisu = stdIn.nextInt();
            }while (kisu <2 || kisu > 36);

            dno = cardConvR(no, kisu, cno);

            System.out.print(kisu + "진수로는 ");
            for(int i = dno -1; i >= 0; i--){
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1:예/ 0:아니오)" );
            retry = stdIn.nextInt();
        }while (retry == 1);

        stdIn.close();
    }
}

/*
print:
10진수를 기수 변화합니다.
변환하는 음이 아닌 정수 : 59
어떤 진수로 변환할까요? (2~36) : 2
 2|    59
  +------
 2|    29 ··· 1
  +------
 2|    14 ··· 1
  +------
 2|     7 ··· 0
  +------
 2|     3 ··· 1
  +------
 2|     1 ··· 1
  +------
        0 ··· 1
2진수로는 111011입니다.
한 번 더 할까요? (1:예/ 0:아니오)0
*/

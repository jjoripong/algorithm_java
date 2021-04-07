import java.util.Scanner;

public class practice06 {

    static int cardConvR(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x%r);
            x /= r;
        }while (x !=0);
        return digits;
    }

/* //안되는 코드    
    static int cardConv(int x, int kisu, char[] d){
        int digits = 0;
        int no = x;
        int nmj = 0;
        while (no > 0){
            no/=kisu;
            digits++;
        }
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";\
        int index = digits;

        do {
            d[index--] = dchar.charAt(((no*kisu)+nmj)%kisu);
            no =(no*kisu)+nmj;
            nmj = ((no*kisu)+nmj)%kisu;
        }while (no < x);
        return digits;
    }*/

    static int cardConv(int x, int kisu, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x%kisu);
            x /= kisu;
        }while (x !=0);
        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }
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

            //dno = cardConvR(no, kisu, cno);
            dno = cardConv(no, kisu, cno);

            System.out.print(kisu + "진수로는 ");
            /*for(int i = dno -1; i >= 0; i--){
                System.out.print(cno[i]);
            }*/
            for(int i = 0; i <= dno; i++){
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
2진수로는 111011 입니다.
한 번 더 할까요? (1:예/ 0:아니오)0
*/

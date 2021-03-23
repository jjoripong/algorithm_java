import java.util.Scanner;

public class practic16 {

    static void spira(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n-i; j >= 1; j--){
                System.out.printf(" ");
            }
            for(int j = 1; j < i; j++){
                System.out.printf("*");
            }
            System.out.printf("*");
            for(int j = 1; j < i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    //피라미드
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n;

        do{
            System.out.println("몇 단 삼각형 입니까?");
            System.out.println("단수 : ");
            n = stdIn.nextInt();
        } while (n <= 0);
        spira(n);
    }
}
//print
/*
몇 단 삼각형 입니까?
단수 :
5
    *
   ***
  *****
 *******
*********

*/
import java.util.Scanner;

public class practice17 {

    static void npira(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n-i; j >= 1; j--){
                System.out.printf(" ");
            }
            for(int j = 1; j < i; j++){
                System.out.printf("%d",i%10);
            }
            System.out.printf("%d",i%10);
            for(int j = 1; j < i; j++){
                System.out.printf("%d",i%10);
            }
            System.out.println();
        }
    }

    //왼쪽 아래가 직각인 이등변 삼각형
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n;

        do{
            System.out.println("몇 단 삼각형 입니까?");
            System.out.println("단수 : ");
            n = stdIn.nextInt();
        } while (n <= 0);
        npira(n);
    }
}
//print
/*
몇 단 삼각형 입니까?
단수 : 
5
    1
   222
  33333
 4444444
555555555

*/

import java.util.Scanner;

public class practice15 {

    static void triangleLB(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    static void triangleLU(int n){
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    static void triangleRB(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n-i; j >= 1; j--){
                System.out.printf(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    static void triangleRU(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                System.out.printf(" ");
            }
            for(int j = n-i; j >= 0; j--){
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    //직각 이등변 삼각형
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n;

        do{
            System.out.println("몇 단 삼각형 입니까?");
            System.out.println("단수 : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        System.out.println("왼쪽 아래 직각");
        triangleLB(n);
        System.out.println("왼쪽 위 직각");
        triangleLU(n);
        System.out.println("오른쪽 아래 직각");
        triangleRB(n);
        System.out.println("오른쪽 위 직각");
        triangleRU(n);
    }
}
//print
/*
몇 단 삼각형 입니까?
단수 : 
5
왼쪽 아래 직각
*
**
***
****
*****
왼쪽 위 직각
*****
****
***
**
*
오른쪽 아래 직각
    *
   **
  ***
 ****
*****
오른쪽 위 직각
*****
 ****
  ***
   **
    *
*/

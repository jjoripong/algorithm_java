import java.util.Scanner;

public class practice14 {

    //입력한 수를 한 변으로 하는 정사각형
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("사각형을 출력합니다.");
        System.out.println("단수 : ");
        int a = stdIn.nextInt();

        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= a; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
import java.util.Scanner;

public class practice10 {

    //b-a
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int b;
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();

        do{
            System.out.println("b의 값 : ");
            b = stdIn.nextInt();
            if(b<= a){
                System.out.println("a보다 큰 값을 입력하세요!");
            }
        }while (a>=b);

        System.out.println("b-a는"+ (b-a) +"입니다.");
    }
}
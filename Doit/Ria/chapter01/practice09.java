import java.util.Scanner;

public class practice09 {

    //a부터 b까지의 합
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("a부터 b까지의 합을 구합니다.");
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.println("b의 값 : ");
        int b = stdIn.nextInt();

        int sum = 0;
        if(a<b){
            for (int i = a; i <= b; i++){
                sum += i;
            }
        }else{
            for (int i = b; i <= a; i++){
                sum += i;
            }
        }
        System.out.println(a+"부터 "+b+"까지의 합은 "+sum+"입니다.");
    }
}
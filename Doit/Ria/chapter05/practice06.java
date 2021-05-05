import java.util.Scanner;
/*
Q6 : 기둥 이름 출력 (A기둥, B기둥, C기둥)
*/
public class practice06 {

    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.println("원반[" + no + "]을 " + getName(x) + "기둥에서 " + getName(y) + "기둥으로 옮김");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static String getName(int x){
        if(x == 1){
            return "A";
        }else if(x == 2){
            return "B";
        } else if(x == 3){
            return "C";
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수：");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}

/*
print:
하노이의 탑
원반 개수：3
원반[1]을 A기둥에서 C기둥으로 옮김
원반[2]을 A기둥에서 B기둥으로 옮김
원반[1]을 C기둥에서 B기둥으로 옮김
원반[3]을 A기둥에서 C기둥으로 옮김
원반[1]을 B기둥에서 A기둥으로 옮김
원반[2]을 B기둥에서 C기둥으로 옮김
원반[1]을 A기둥에서 C기둥으로 옮김
*/
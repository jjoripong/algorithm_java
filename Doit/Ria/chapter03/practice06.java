import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practice01 {
    static int[] randArray(int num){
        Random rand = new Random();

        int[] a = new int[num+1];
        for(int index =0; index < num; index++){
            a[index] = rand.nextInt(100);
            System.out.println("x["+index+"] : "+ a[index]);
        }

        return a;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        int num = rand.nextInt(10)+1;
        System.out.println("요솟수 : "+ num);

        int[] array = randArray(num);

        //int key = rand.nextInt(100);
        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();
        stdIn.close();

        int haveSeq = Arrays.binarySearch(array, key);

        if(haveSeq < 0){
            System.out.printf("요소가 없습니다. 삽입 포인트는 %d 입니다.",(haveSeq+1)*-1);
        }else{
            System.out.println("검색한 값"+key+"는 x["+haveSeq+"] 에 있습니다.");
        }
    }
}

/*
print:
요솟수 : 8
x[0] : 70
x[1] : 30
x[2] : 51
x[3] : 82
x[4] : 73
x[5] : 48
x[6] : 73
x[7] : 79
검색할 값 : 50
요소가 없습니다. 삽입 포인트는 2 입니다.
*/

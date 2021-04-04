import java.util.Random;

public class practice03 {

    static int sumOf(int[] a){
        int sum = 0;

        for(int index =0; index < a.length; index++){
            sum += a[index];
        }
        return sum;
    }

    static void printArray(int[] a){
        for(int index = 0; index < a.length ; index++){
            System.out.printf("%3d | ",index);
        }
        System.out.println(" ");
        for(int index = 0; index < a.length ; index++){
            System.out.printf("%3d | ",a[index]);
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 합을 구합니다.");
        int num = rand.nextInt(10)+1;

        int[] sumArray = new int[num];

        for(int index =0; index < num; index++){
            sumArray[index] = rand.nextInt(100);
        }
        printArray(sumArray);

        System.out.println("키의 합: "+sumOf(sumArray));
    }
}

/*
print:
키의 합을 구합니다.
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |  
 46 |  59 |  93 |  84 |   8 |  53 |  73 |  56 |  
키의 합: 472
*/

import java.util.Random;

public class practice04 {

    static void copy(int[] a, int[] b){
        for(int index =0; index < a.length; index++){
            b[index] = a[index];
        }
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

        System.out.println("Array를 copy합니다.");
        int num = rand.nextInt(10)+1;

        int[] standardArray = new int[num];
        int[] copyArray = new int[num];

        for(int index =0; index < num; index++){
            standardArray[index] = rand.nextInt(100);
        }
        System.out.println("기준 Array : ");
        printArray(standardArray);

        System.out.println("복사한 Array : ");
        copy(standardArray, copyArray);
        printArray(copyArray);

        System.out.println("복사한 Array2 : ");
        printArray(standardArray.clone());
    }
}

/*
print:
Array를 copy합니다.
기준 Array :
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |
 21 |  32 |  29 |  89 |  69 |  99 |  28 |  16 |  54 |  45 |
복사한 Array :
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |
 21 |  32 |  29 |  89 |  69 |  99 |  28 |  16 |  54 |  45 |
복사한 Array2 :
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |
 21 |  32 |  29 |  89 |  69 |  99 |  28 |  16 |  54 |  45 |
*/

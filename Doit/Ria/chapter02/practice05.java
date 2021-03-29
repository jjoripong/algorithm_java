import java.util.Random;

public class practice05 {

    static void rcopy(int[] a, int[] b){
        for(int index =0; index < a.length; index++){
            b[a.length-index-1] = a[index];
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

        System.out.println("Array를 역순으로 copy합니다.");
        int num = rand.nextInt(10)+1;

        int[] standardArray = new int[num];
        int[] copyArray = new int[num];

        for(int index =0; index < num; index++){
            standardArray[index] = rand.nextInt(100);
        }
        System.out.println("기준 Array : ");
        printArray(standardArray);

        System.out.println("역순 복사한 Array : ");
        rcopy(standardArray, copyArray);
        printArray(copyArray);
    }
}

/*
print:
Array를 역순으로 copy합니다.
기준 Array : 
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  
 27 |  90 |  36 |  36 |  99 |  26 |  21 |  17 |  41 |  60 |  
역순 복사한 Array : 
  0 |   1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  
 60 |  41 |  17 |  21 |  26 |  99 |  36 |  36 |  90 |  27 |
*/

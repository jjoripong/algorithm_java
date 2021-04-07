import java.util.Random;

public class practice02 {

    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;
        a[n] = key;

        printIndex(n);

        for(int seq :a){
            printStar(i,n);
            printArray(a,n,i);
            if(key == seq){
                break;
            }
            i++;
        }
        return i == n? -1:i;
    }

    static int[] randArray(int num){
        Random rand = new Random();

        int[] a = new int[num+1];
        for(int index =0; index < num; index++){
            a[index] = rand.nextInt(100);
            System.out.println("x["+index+"] : "+ a[index]);
        }

        return a;
    }

    static void printStar(int i, int n){
        System.out.printf("  |");
        if(i <= 0){
            System.out.printf("   *");
        } else if(i == n){
            return;
        }else{
            for(int index = 0; index < i; index++){
                System.out.printf("    ");
            }
            System.out.printf("   *");
        }
        System.out.println();
    }

    static void printArray(int[] a,int n, int i){
        if(i == n)return;
        System.out.printf(" %d|",i);
        for(int index = 0; index < n; index++){
            System.out.printf("%4d",a[index]);
        }
        System.out.println();
        System.out.println("  |");
    }

    static void printIndex(int n){
        for(int index = 0; index < n; index++){
            System.out.printf("  | ");
            System.out.printf("%d",index);
        }
        System.out.printf("\n--+");
        for(int index = 0; index < n; index++){
            System.out.printf("-----");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int num = rand.nextInt(10)+1;
        System.out.println("요솟수 : "+ num);

        int[] array = randArray(num);

        int key = rand.nextInt(100);
        System.out.println("검색할 값 : "+key);

        int haveSeq = seqSearchSen(array, num, key);

        if(haveSeq == -1){
            System.out.println("\n요소가 없습니다.");
        }else{
            System.out.println("검색한 값"+key+"는 x["+haveSeq+"] 에 있습니다.");
        }
    }
}

/*
print:
요솟수 : 4
x[0] : 84
x[1] : 51
x[2] : 0
x[3] : 67
검색할 값 : 42
  | 0  | 1  | 2  | 3
--+-------------------- 
  |   *
 0|  84  51   0  67
  |
  |       *
 1|  84  51   0  67
  |
  |           *
 2|  84  51   0  67
  |
  |               *
 3|  84  51   0  67
  |
  |
요소가 없습니다.

*/
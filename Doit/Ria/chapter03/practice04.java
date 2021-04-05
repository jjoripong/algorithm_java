import java.util.Arrays;
import java.util.Random;

public class practice04 {

    static int binSearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;
        printIndex(a);
        do{
            int pc = (pl + pr)/2;
            if(pl < pr){
                printLocation(pl,pc,pr,n);
                printArray(pc,a);
            }
            if (a[pc] == key){
                return pc;
            }else if(a[pc] > key){
                pr = pc-1;
            }else{
                pl = pc +1;
            }
        }while (pl <= pr);

        return -1;
    }

    static int[] randArray(int num){
        Random rand = new Random();

        int[] a = new int[num];
        for(int index =0; index < num; index++){
            a[index] = rand.nextInt(100);
        }
        Arrays.sort(a);
        return a;
    }

    static void printLocation(int pl, int pc, int pr, int n){
        /*int first = pc-pl;
        int last = pr-pc;
        if(first<=0) first = 1;
        if(last<=0) last = 1;
        System.out.printf(String.format("\n%%%ds",(pl*2)+3),"");
        System.out.printf(String.format("<-%%%ds+",(first*2)+3),"");
        System.out.printf(String.format("%%%ds->\n",(last*2)+3),"");*/
        /*  <-       +         ->
        2|  0  6  8 36 41 67 90
                <-     +     ->
        4|  0  6  8 36 41 67 90
        적당한 값을 찾기 어려움
        */
        System.out.printf("\n   ");
        for(int index = 0; index < n; index++){
            if(index == pl){
                System.out.printf("<- ");
            }else if (index == pc){
                System.out.printf(" + ");
            }else if (index == pr){
                System.out.printf(" ->");
            }else{
                System.out.printf("   ");
            }
        }
        System.out.printf("\n");
    }

    static void printArray(int pc, int[] a){
        System.out.printf("%d|",pc);
        for(int value : a){
            System.out.printf("%3d",value);
        }
    }

    static void printIndex(int[] a){
        System.out.printf("  |");
        for(int index= 0;index< a.length;index++){
            System.out.printf("%3d",index);
        }
        System.out.printf("\n--+");
        for(int idx= 0;idx< a.length;idx++){
            System.out.printf("---");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int num = rand.nextInt(10)+6;
        System.out.println("요솟수 : "+ num);

        int[] array = randArray(num);

        int key = rand.nextInt(100);
        System.out.println("검색할 값 : "+key);

        int haveSeq = binSearch(array, num, key);

        if(haveSeq < 0){
            System.out.println("\n요소가 없습니다.");
        }else{
            System.out.println("\n검색한 값"+key+"는 x["+haveSeq+"] 에 있습니다.");
        }
    }
}

/*
print:
요솟수 : 12
검색할 값 : 84
  |  0  1  2  3  4  5  6  7  8  9 10 11
--+------------------------------------
   <-              +                 ->
5| 15 17 27 30 33 36 49 62 69 79 88 91
                     <-     +        ->
8| 15 17 27 30 33 36 49 62 69 79 88 91
                              <-  +  ->
10| 15 17 27 30 33 36 49 62 69 79 88 91
요소가 없습니다.

요솟수 : 15
검색할 값 : 86
  |  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14
--+---------------------------------------------
   <-                    +                    ->
7| 19 21 27 28 30 38 39 44 44 53 54 71 74 86 97
                           <-        +        ->
11| 19 21 27 28 30 38 39 44 44 53 54 71 74 86 97
                                       <-  +  ->
13| 19 21 27 28 30 38 39 44 44 53 54 71 74 86 97
검색한 값86는 x[13] 에 있습니다.
*/

import java.util.Scanner;

public class practice03 {

    static int searchIdx(int[] a, int n, int key, int[] idx){
        int i = 0;
        int count = 0;

        for(int seq :a){
            if(key == seq){
                idx[count] = i;
                count++;
            }
            i++;
        }
        return count;
    }

    static void printArray(int[] a){
        int i = 0;
        System.out.print("{");
        do{
            System.out.print(a[i]+" ");
            i++;
        }while (a[i] != 0);
        System.out.print("}");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        System.out.println("검색할 값 : ");
        int key = stdIn.nextInt();

        int[] cIdx = new int[num]; //초기화..num말고 다른 방법이 있나?
        int haveSeq = searchIdx(x, num, key, cIdx);

        if(haveSeq == 0){
            System.out.println("\n요소가 없습니다.");
        }else{
            System.out.println("검색한 값"+key+"는 "+haveSeq+"개가 있습니다.");
        }

        printArray(cIdx);
    }
}

/*
print:
요솟수 : 
7
x[0]：12
x[1]：24
x[2]：12
x[3]：36
x[4]：12
x[5]：48
x[6]：12
검색할 값 : 
12
검색한 값12는 4개가 있습니다.
{0 2 4 6 }
*/
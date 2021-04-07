import java.util.Random;

public class practice01 {

    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;
        a[n] = key;

        for(int seq :a){
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

    public static void main(String[] args) {
        Random rand = new Random();

        int num = rand.nextInt(10)+1;
        System.out.println("요솟수 : "+ num);

        int[] array = randArray(num);

        int key = rand.nextInt(100);
        System.out.println("검색할 값 : "+key);

        int haveSeq = seqSearchSen(array, num, key);

        if(haveSeq == -1){
            System.out.println("요소가 없습니다.");
        }else{
            System.out.println("검색한 값"+key+"는 x["+haveSeq+"] 에 있습니다.");
        }
    }
}

/*
print:
요솟수 : 3
x[0] : 43
x[1] : 52
x[2] : 44
검색할 값 : 36
요소가 없습니다.

요솟수 : 8
x[0] : 95
x[1] : 69
x[2] : 56
x[3] : 60
x[4] : 0
x[5] : 65
x[6] : 11
x[7] : 14
검색할 값 : 11
검색한 값11는 x[6] 에 있습니다.
*/

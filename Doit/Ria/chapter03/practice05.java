//검색할 값과 같은 값을 갖는 요소가 하나 이상일 경우 맨 앞의 요소 찾기
public class practice05 {

    static int binSearch(int[] a, int n, int key){
        int index = 0;
        int pl = 0;
        int pr = n-1;
        do{
            int pc = (pl + pr)/2;
            if (a[pc] == key){
                pr--;
                index = pc;
            }else if(a[pc] > key){
                pr = pc-1;
            }else{
                pl = pc +1;
            }
        }while (pl <= pr);

        return index == 0? -1:index;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,7,7,7,8,8,9,9};
        int num = array.length;
        System.out.println("요솟수 : "+ num);

        int key = 7;
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
요솟수 : 11
검색할 값 : 7

검색한 값7는 x[3] 에 있습니다.
*/

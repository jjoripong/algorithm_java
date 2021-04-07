public class practice02 {

    static void swap(int[]a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void printArray(int[] a){
        for(int index = 0; index < a.length ; index++)
            System.out.print(a[index]+" ");
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] height = new int[]{5, 10, 73, 2, -5, 42};
        printArray(height);
        
        for(int index=0; index< height.length/2; index++){
            System.out.println("a["+index+"]과(와) a["+(height.length-index-1)+"]를 교환합니다.");
            swap(height,index,height.length-index-1);
            printArray(height);
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }
}

/*
print:
5 10 73 2 -5 42  
a[0]과(와) a[5]를 교환합니다.
42 10 73 2 -5 5  
a[1]과(와) a[4]를 교환합니다.
42 -5 73 2 10 5  
a[2]과(와) a[3]를 교환합니다.
42 -5 2 73 10 5  
역순 정렬을 마쳤습니다.
*/

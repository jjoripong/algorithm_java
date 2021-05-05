import com.sun.org.apache.xml.internal.utils.IntStack;

import java.util.Scanner;
/*
Q5 : recur3 재귀함수를 비재귀적으로 구현

//너무 어려워요...
*/
public class practice05 {

    /*static void recur3(int n) {
        if(n>0) {
            recur3(n-1);
            recur3(n-2);
            System.out.println(n);
        }
    }*/

    public static void main(String[] args) {
        recur3(4);
        System.out.println("");
    }
}

/*
예상 print:
1
2
1
3
1
2
4
*/
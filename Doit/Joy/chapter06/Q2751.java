import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

/**
 * BaekJoon Online Judge : 2751
 * link: https://www.acmicpc.net/problem/2751
 * 시간 제한 : 2초
 * 1. 내가 구현한 퀵정렬로 했더니 시간초과남ㅎㅎ
 * 2. 내장 sort 사용 
 */

public class Q2751 {
    
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input.add(Integer.parseInt(st.nextToken()));
        }

        //sort 
        Collections.sort(input);
        
        // ouput
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(input.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

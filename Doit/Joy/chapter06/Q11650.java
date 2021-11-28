import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BaekJoon Online Judge : 11650
 * link: https://www.acmicpc.net/problem/11650 
 * 시간 제한 : 1초 
 * 결과 : 시간 초과
 */

public class Q11650 {
    
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Pair> input = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // input x
            int y = Integer.parseInt(st.nextToken()); // input y
            input.add(new Pair(x, y));
        }

        //sort 
        quickSort(input, 0, input.size()-1);
        // test();

        // ouput
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(input.get(i).x + "" + input.get(i).y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void test() {
        List<Pair> mock = new LinkedList<>();
        mock.add(new Pair(3, -1));
        mock.add(new Pair(1, 1));
        mock.add(new Pair(1, -1));
        mock.add(new Pair(2, 2));
        mock.add(new Pair(3, 3));

        for (int i = 0; i < mock.size(); i++) {
            System.out.println(mock.get(i).x + "," + mock.get(i).y);
        }

        quickSort(mock, 0, 4);
        System.out.println("after sort");

        for (int i = 0; i < mock.size(); i++) {
            System.out.println(mock.get(i).x + "," + mock.get(i).y);
        }
    }

    public static void quickSort(List<Pair> a, int left, int right) {
    	int pl = left;					// 왼쪽 커서
		int pr = right;					// 오른쪽 커서
        int x = a.get((pl + pr) / 2).x;		// 피벗

		do {
			while (a.get(pl).x < x) pl++;
			while (a.get(pr).x > x) pr--;
			if (pl <= pr)
                swap(a, pl++, pr--);
    		} while (pl <= pr);

		if (left < pr)  quickSort(a, left, pr);
		if (pl < right) quickSort(a, pl, right);
	}


    public static void swap(List<Pair> a, int idx1, int idx2) {
        int x = a.get(idx1).x;  
        int y = a.get(idx1).y;

        a.get(idx1).x = a.get(idx2).x;

        a.get(idx2).x = x;

        if (a.get(idx1).x == a.get(idx2).x && a.get(idx1).y < a.get(idx2).y) {
            return;
        } else {
            a.get(idx1).y = a.get(idx2).y;
            a.get(idx2).y = y;
        }
	}

    static class Pair {
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
        public Integer second() {
            return x;
        }
        public Integer first() {
            return y;
        }
    }
}

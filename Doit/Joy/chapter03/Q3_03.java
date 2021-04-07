import java.util.Scanner;

public class Q3_03 {
	
	// 요솟수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx에 저장
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		// 순차 탐색
		int i, cnt = 0;
		
		for (i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[cnt++] = i;
			}
		}

		return cnt;
	}
	
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		int[] idx = new int[num];
		
		// 사용자 입력 배열 생성
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int k = stdIn.nextInt();
				
		int idxNum = searchIdx(x, num, k, idx);
		stdIn.close();
	}
	
}

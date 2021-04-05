import java.util.Scanner;

public class Q3_01 {

	// 순차 탐색 + 보초값
	// 종료 조건 : 값을 찾았을 때, 끝까지 갔을 때
	static int seqSearchSen(int[] a, int n, int key) {
		a[n] = key; // 보초값
		int i;
		//		while(true) {
		//		if (a[i] == key)
		//			break;
		//		i++;
		//	}
		
		for (i = 0; i < n; i++) {
			if (a[i] == key) 
				break;
		}
		
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1]; //보초값 생각해서 요솟수 + 1
		
		// 사용자 입력 배열 생성
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int k = stdIn.nextInt();
		
		int idx = seqSearchSen(x, num, k); // 크기가 num인 배열 x에서 k값 검색
		
		if (idx == -1) 
			System.out.printf("찾으시는 값인 %d가 없습니다.\n", k);
		else
			System.out.printf("%d는 x[%d]에 있습니다.", k, idx);
		
		stdIn.close();
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Q3_06 {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0]: ");
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]: ");
				x[i] = stdIn.nextInt();
			} while(x[i] < x[i-1]);		// 앞 요소보다 작으면 다시 입력
		}
		
		System.out.print("검색할 값: ");
		int k = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x, k);
		
		if (idx < 0)
			// 탐색 실패시 : 삽입 포인트 -idx-1 반환
			System.out.printf("찾으시는 값 %d 없습니다. 삽입 포인트 인덱스%d 값:%d \n", k, -(idx+1) ,x[-(idx+1)]);
		else
			System.out.printf("%d는 x[%d]에 있습니다.", k, idx);
		
		stdIn.close();
	}

}

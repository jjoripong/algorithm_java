import java.util.Scanner;

public class Q3_04 {

	// 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
	static int binSearchPrint(int[] a, int n, int key) {
		int i, f = 0, l = n-1;
		
		// 첫줄
		System.out.print("   |");
		for(i=0; i < n; i++) 
			System.out.printf(String.format("%2d", i));	
		
		// 둘째줄
		System.out.print("\n---+");
		for (i=0; i < 4*n; i++) 
			System.out.printf("-");
		
		
		// 이진 탐색
		do {
			int m = (f+l)/2;
			//  m|  <- : k, + : m, ->: 1
			System.out.printf("\n   |");
			System.out.printf(String.format("%%%ds<-", 4*f+1),"");
			System.out.printf(" + ");
			System.out.printf(String.format("%%%ds->", 4*l-1),"");
			System.out.printf("\n  %d|", m);
			for (int j=0; j < n; j++) {
				System.out.printf(" %d ", a[j]);
			}
			System.out.printf("\n   |");
			System.out.println();
			
			if (a[m] == key) {
				return m;
			} else if (a[m] > key) {
				l = m-1;
			} else {
				f = m+1;
			}
		} while (f <= l);
		return -1;
	}
	
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
		
		int idx = binSearchPrint(x, num, k);
		
		if (idx == -1) 
			System.out.printf("찾으시는 값인 %d가 없습니다.\n", k);
		else
			System.out.printf("%d는 x[%d]에 있습니다.", k, idx);
		
		stdIn.close();
	}
}

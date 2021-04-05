import java.util.Scanner;

public class Q3_05 {

	static int binSearchX(int[] a, int n, int key) {
		int f = 0, l = n-1;
		do {
			int m = (f+l)/2;
			
			if (a[m] == key) {
				while(a[m] == a[m-1]) m = m-1;
				return m;
			} else if (a[m] < key) 
				f = m + 1;
			else 
				l = m - 1;
			
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
		
		int idx = binSearchX(x, num, k);
		
		if (idx == -1) 
			System.out.printf("찾으시는 값인 %d가 없습니다.\n", k);
		else
			System.out.printf("%d는 x[%d]에 있습니다.", k, idx);
		
		stdIn.close();
	}

}


요솟수: 5
오름차순으로 입력하세요.
x[0]: 0
x[1]: 1
x[2]: 1
x[3]: 1
x[4]: 3
검색할 값: 1
1는 x[1]에 있습니다.
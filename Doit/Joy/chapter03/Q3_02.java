import java.util.Scanner;

public class Q3_02 {

	static int printSeqSearch(int[] x, int n, int k) {
		x[n] = k; // 보초값
		int i, j;
		// 별로다ㅡㅡ
		System.out.print("    |");

		for (i = 0; i < n; i++) {
			System.out.printf(" %d ", i);
		}
		
		System.out.print("\n----+--");
		
		for (i = 0; i < n; i++) {
			System.out.printf("---");
		}
		System.out.println();

		// 선형 탐색
		for (i = 0; i < n; i++) {
			System.out.print("    |");
			for (j=0; j < n; j++) {
				if (j==i) System.out.println(" *");
				else System.out.print("   ");
			}
			
			System.out.printf("\n   %d|", i);

			for (j=0; j < n; j++) {
				System.out.printf(" %d ", j);
			}
			System.out.print("\n    |\n");
			
			if (x[i] == k) break;
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
		
		int idx = printSeqSearch(x, num, k); // 크기가 num인 배열 x에서 k값 검색
		
		if (idx == -1) 
			System.out.printf("찾으시는 값인 %d가 없습니다.\n", k);
		else
			System.out.printf("%d는 x[%d]에 있습니다.", k, idx);
		
		stdIn.close();
	}
}

//요솟수: 7
//x[0] : 6
//x[1] : 4
//x[2] : 3
//x[3] : 2
//x[4] : 1
//x[5] : 9
//x[6] : 8
//검색할 값: 3
//    | 0  1  2  3  4  5  6 
//----+-----------------------
//    | *
//                  
//   0| 0  1  2  3  4  5  6 
//    |
//    |    *
//               
//   1| 0  1  2  3  4  5  6 
//    |
//    |       *
//            
//   2| 0  1  2  3  4  5  6 
//    |
//3는 x[2]에 있습니다.

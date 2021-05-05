public class Q5_08 {
	static boolean[] flag_a = new boolean[8]; // 행 퀸 배치 여부
	static boolean[] flag_b = new boolean[15]; // ／대각선 퀸 배치 여부?
	static boolean[] flag_c = new boolean[15]; // ＼대각선 퀸 배치 여부?
	static int[] pos = new int[8]; // 각 열 퀸 위치

	// 각 열의 퀸 위치 출력
	static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				System.out.printf("%s", j == pos[i] ? "■" : "□");
			System.out.println();
		}
		System.out.println();
	}

	// i 열 알맞은 위치에 퀸을 배치
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false && // 가로(j행)에 미배치
					flag_b[i + j] == false && // ／대각선에 미배치
					flag_c[i - j + 7] == false) { // ＼대각선에 미배치
				pos[i] = j; // 퀸을 j행에 배치
				if (i == 7) // 모든 열에 배치 마침
					print();
				else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}

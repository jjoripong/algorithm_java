import java.util.Scanner;
// 하노이의 탑(기둥 이름을 문자열로 나타냄)

class Q5_06 {
    enum Top {
        A(1, "A기둥"),
        B(2, "B기둥"),
        C(3, "C기둥");

        private int num;
        private String name;

        Top(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public static String findNameByNum(int num) {
            for (Top i : Top.values()) {
                if (i.num == num) return i.name;
            }

            return null;
        }
    }

    // 원반을 x기둥에서 y기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);
        System.out.println(String.format("원반[%d]를 %s에서 %s로 옮김",
                no, 
                Top.findNameByNum(x), 
                Top.findNameByNum(y)));

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }
    

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("하노이의 탑");
		System.out.print("원반의 갯수：");
		int n = stdIn.nextInt();

		move(n, 1, 3); // 1기둥에 쌓인 n개를 3기둥에 옮김
	}
}
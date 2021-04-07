import java.util.Scanner;

public abstract class Common {

	public static int inputNumber() {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요: ");
		int n = stdIn.nextInt();
		stdIn.close();
		return n;
	}
}

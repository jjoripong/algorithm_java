import java.util.Scanner;

public abstract class Common {

	public static int inputNumber() {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է�����: ");
		int n = stdIn.nextInt();
		stdIn.close();
		return n;
	}
}

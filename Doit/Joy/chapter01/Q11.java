/**
 * 2021.03.21
 * @author Joy
 */


import java.util.Scanner;

public class Q11 {
	public static void q11() {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է�����: ");
		
		Long n = stdIn.nextLong();

		while (n <= 0) {
			System.out.println("0���� ū���� �Է��ϼ���!");
			n = stdIn.nextLong();
		}
		
		stdIn.close();
		
		String sn = Long.toString(n);
		System.out.println("�� ���� " + sn.length() + "�ڸ��Դϴ�.");
	}
	
	public static void main(String args[]) {
		q11();
	}

}


/**
 * 2021.03.21
 * @author Joy
 * 01-2 �ݺ��� (~38p)
 */

public class Q10 extends Common{
	
	public static void q10() {
		int a = inputNumber();
		int b = inputNumber();
		
		while (b <= a) {
			System.out.println("a���� ū���� �Է��ϼ���!");
			b = inputNumber();
		};
		System.out.println(b+ "-" + a + "=" + (b-a));
	}
	
	public static void main(String args[]) {
		q10();
	}


}

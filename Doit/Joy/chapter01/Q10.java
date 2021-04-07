
/**
 * 2021.03.21
 * @author Joy
 */

public class Q10 extends Common{
	
	public static void q10() {
		int a = inputNumber();
		int b = inputNumber();
		
		while (b <= a) {
			System.out.println("a보다 큰수를 입력해주세요!");
			b = inputNumber();
		};
		System.out.println(b+ "-" + a + "=" + (b-a));
	}
	
	public static void main(String args[]) {
		q10();
	}


}

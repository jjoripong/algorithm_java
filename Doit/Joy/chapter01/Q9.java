
/**
 * 2021.03.21
 * @author Joy
 * 01-2 ¹Ýº¹¹® (~38p)
 */

public class Q9 {

	private static int sumof(int a, int b) {
		System.out.println("start sumof a:" + a + " b: " + b);

		int result = 0;
		if (a <= b) {
			while(a <= b) {
				result += a;
				a++;
			}
		} else if (a > b){
			while (b <= a) {
				result += b;
				b++;
			}
		} else return a;
		
		System.out.println("result: " + result);
		return result;
	}

	public static void main(String args[]) {
		sumof(4,6);
		sumof(5,5);
		sumof(6,3);
	}
}

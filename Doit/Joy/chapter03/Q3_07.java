import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q3_08 {

	static class PhyscData {
		private String name;
		private int height;
		private double vision;
		
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
		public String toString() {
			return name + " " + height + " " + vision;
		}
		
		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
		public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhyscData> {
			@Override
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 :0;
			}
		}
		
		private static class VisionOrderComparator implements Comparator<PhyscData> {
			@Override
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.vision > d2.vision) ? 1 : (d1.vision < d2.vision) ? -1 :0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] ascending = { new PhyscData("이나령", 162, 0.3), new PhyscData("전서현", 168, 0.7),
				new PhyscData("이수민", 169, 0.8), new PhyscData("홍준기", 171, 1.0), 
				new PhyscData("유지훈", 173, 1.2), new PhyscData("이호연", 174, 1.2),
				new PhyscData("김한결", 175, 2.0), };
			
//		System.out.print("몇 cm인 사람을 찾고 있나요? : ");
		
//		int height = stdIn.nextInt();
		// 배열 x에서 키가 height인 요소를 HEIGHT_ORDER에 의해 검색
//		int idx = Arrays.binarySearch(ascending, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
		System.out.print("시력이 몇인 사람을 찾고 있나요? : ");

		double vision = stdIn.nextDouble();
		int idx = Arrays.binarySearch(ascending, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

		if (idx < 0)
			System.out.println("요소가 없습니다.");
		else {
			System.out.println("x[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터: " + ascending[idx]);
		}
		stdIn.close();
	}
}

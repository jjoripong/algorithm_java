public class Q2_10 {

    // 시력의 분포 (0.0부터 0.1 단위로 21개)
	static final int VMAX = 21;

	static class PhyscData {
		String name; 
		double vision; 

		PhyscData(String name, double vision) {
			this.name = name;
			this.vision = vision;
		}
	}

	static void distVision(PhyscData[] dat, int[] dist) {
		int i = 0;

		dist[i] = 0;
		for (i = 0; i < dat.length; i++)
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
				dist[(int) (dat[i].vision * 10)]++;
	}

	public static void main(String[] args) {
		PhyscData[] x = { new PhyscData("이나령", 0.3), new PhyscData("전서현", 0.7),
				new PhyscData("이수민", 2.0), new PhyscData("홍준기", 1.5), new PhyscData("유지훈", 1.2),
				new PhyscData("이호연", 1.2), new PhyscData("김한결", 0.8), };
		int[] vdist = new int[VMAX]; 

		System.out.println("■ 신체검사 리스트 ■");
		System.out.println(" 이름      시력");
		System.out.println("--------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%5.1f\n", x[i].name, x[i].vision);

		distVision(x, vdist);

		System.out.println("\n시력의 분포");
		for (int i = 0; i < VMAX; i++) {
			System.out.printf("%3.1f~：", i / 10.0);
			for (int n = 0; n < vdist[i]; n++)
				System.out.print('*');
			System.out.println();
		}
	}
}

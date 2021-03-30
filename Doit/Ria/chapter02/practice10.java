public class practice10 {
    static final int VMAX = 21;	// 시력 분포(0.0에서 0.1 단위로 21개）

    static class PhyscData {
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name 	= name;
            this.height = height;
            this.vision = vision;
        }
    }

    static double aveHeight(PhyscData[] dat) {
        double sum = 0;

        for (int i = 0; i < dat.length; i++)
            sum += dat[i].height;

        return sum / dat.length;
    }

    static void distVision(PhyscData[] dat, int[] dist) {
        int i = 0;

        dist[i] = 0;
        for (i = 0; i < dat.length; i++)
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                dist[(int)(dat[i].vision * 10)]++;
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("Ria", 162, 0.6),
                new PhyscData("Joy", 173, 0.7),
                new PhyscData("Kailey", 175, 2.0),
                new PhyscData("a", 171, 0.7),
                new PhyscData("b", 168, 0.4),
                new PhyscData("c", 174, 1.2),
                new PhyscData("d", 169, 0.7),
        };
        int[] vdist = new int[VMAX];

        System.out.println("-------신체검사 리스트------");
        System.out.println(" 이름         키       시력");
        System.out.println("-------------------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s   %3d    %5.1f\n", x[i].name, x[i].height, x[i].vision);

        System.out.printf("\n평균 키：%5.1fcm\n", aveHeight(x));

        distVision(x, vdist);

        System.out.println("\n시력 분포");
        for (int i = 0; i < VMAX; i++){
            System.out.printf("%3.1f~：", i / 10.0);
            for(int num=0; num < vdist[i]; num++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

/*
print:
-------신체검사 리스트------
 이름         키       시력
-------------------------
Ria        162      0.6
Joy        173      0.7
Kailey     175      2.0
a          171      0.7
b          168      0.4
c          174      1.2
d          169      0.7

평균 키：170.3cm

시력 분포
0.0~：
0.1~：
0.2~：
0.3~：
0.4~：*
0.5~：
0.6~：*
0.7~：***
0.8~：
0.9~：
1.0~：
1.1~：
1.2~：*
1.3~：
1.4~：
1.5~：
1.6~：
1.7~：
1.8~：
1.9~：
2.0~：*
*/

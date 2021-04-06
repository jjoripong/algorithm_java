import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class practice07 {
	
    static class PhyscData {
        private String name;
        private int    height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;  this.height = height;  this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision < d2.vision) ?  1 : (d1.vision > d2.vision) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        //시력 내림차순
        PhyscData[] x = {
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이나령", 162, 0.3)
        };
        System.out.print("시력이 몇 인 사람을 찾고 있나요?：");
        double vision = stdIn.nextDouble();
        int idx = Arrays.binarySearch(x,new PhyscData("", 0, vision),PhyscData.VISION_ORDER);

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터：" + x[idx]);
        }

        stdIn.close();
    }
}

/*
print:
시력이 몇 인 사람을 찾고 있나요?：0.5
요소가 없습니다.

시력이 몇 인 사람을 찾고 있나요?：0.8
x[3]에 있습니다.
찾은 데이터：김한결 169 0.8

시력이 몇 인 사람을 찾고 있나요?：1.2
x[2]에 있습니다.
찾은 데이터：이호연 174 1.2
 */
import java.util.Random;

public class practice01 {

    static int maxOf(int[] a){
        int max = a[0];

        for(int index =1; index < a.length; index++){
            if (a[index]> max)
                max = a[index];
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 최대값을 구합니다.");
        int num = rand.nextInt(10)+1;
        System.out.println("사람 수: "+num);

        int[] height = new int[num];

        System.out.println("키 값:");

        for(int index =0; index < num; index++){
            height[index] = 100+ rand.nextInt(90);
            System.out.println("int height["+index+"] : "+ height[index]);
        }

        System.out.println("키의 최대값: "+maxOf(height));
    }
}

/*
print:
키의 최대값을 구합니다.
사람 수: 5
키 값:
int height[0] : 149
int height[1] : 165
int height[2] : 155
int height[3] : 180
int height[4] : 175
키의 최대값: 180
*/

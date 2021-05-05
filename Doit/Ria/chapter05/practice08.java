/*
Q8 : 퀸 배치 상황 출력
*/
public class practice01 {

    static boolean[] flag_a = new boolean[8];	// 각 행 확인 (true : 퀸 있음/ false : 퀸 없음)
    static boolean[] flag_b = new boolean[15]; 	// ／대각선 방향 확인
    static boolean[] flag_c = new boolean[15]; 	// ＼ 대각선 방향 확인
    static int[] pos = new int[8];				// 각 열의 퀸의 위치

    // 각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++)
            printMark(pos, i);
        System.out.println();
    }
    static void printMark(int[] pos, int idx){
            int x = indexOf(pos,idx);
            for(int j = 0; j < x; j++){
                System.out.printf("□");
            }
            System.out.printf("■");
            for(int j = x+1; j <= 8; j++){
                System.out.printf("□");
            }
            System.out.println();
    }

    private static int indexOf(int[] iArray, int element){
        int index = -1;

        if(iArray == null)
            return index;

        for(int i=0; i < iArray.length; i++){
            if(iArray[i] == element){
                index = i;
                break;
            }
        }
        return index;
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false &&			  	// 가로(j행)에 배치 되었는가? X
                    flag_b[i + j] == false &&		// 대각선 ／에 배치 되었는가? X
                    flag_c[i - j + 7] == false) {  	// 대각선 ＼에 배치 되었는가? X
                pos[i] = j;							// 퀸을 j행에 배치
                if (i == 7)							// 모든 열에 배치한다면?
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}

/*
print:
■□□□□□□□□
□□□□□□■□□
□□□□■□□□□
□□□□□□□■□
□■□□□□□□□
□□□■□□□□□
□□□□□■□□□
□□■□□□□□□

■□□□□□□□□
□□□□□□■□□
□□□■□□□□□
□□□□□■□□□
□□□□□□□■□
□■□□□□□□□
□□□□■□□□□
□□■□□□□□□

■□□□□□□□□
□□□□□■□□□
□□□□□□□■□
□□■□□□□□□
□□□□□□■□□
□□□■□□□□□
□■□□□□□□□
□□□□■□□□□

.
.
.
□□■□□□□□□
□□□□□■□□□
□□□■□□□□□
□■□□□□□□□
□□□□□□□■□
□□□□■□□□□
□□□□□□■□□
■□□□□□□□□
*/
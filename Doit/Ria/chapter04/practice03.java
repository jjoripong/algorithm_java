package jjoripong;
import java.util.Scanner;

public class practice01 {
    static public class IntStack {
        private int max;            // 스택 용량
        private int ptrA;           // 스택 포인터
        private int ptrB;           // 스택 포인터
        private int[] stk;          // 스택 본체

        // 실행 시 예외 : 스택이 비어 있음
        public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {
            }
        }

        // 실행 시 예외 : 스택이 가득 참
        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {
            }
        }

        // 생성자
        public IntStack(int capacity) {
            ptrA = 0;
            ptrB = capacity-1;
            max = capacity;
            try {
                stk = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        // 스택에 x를 푸시
        public int pushStackA(int x) throws IntStack.OverflowIntStackException {
            if (ptrA-1 == ptrB)// 스택이 가득 참
                throw new IntStack.OverflowIntStackException();
            return stk[ptrA++] = x;
        }
        public int pushStackB(int x) throws IntStack.OverflowIntStackException {
            if (ptrA-1 == ptrB)// 스택이 가득 참
                throw new IntStack.OverflowIntStackException();
            return stk[ptrB--] = x;
        }

        // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
        public int popStackA() throws IntStack.EmptyIntStackException {
            if (ptrA <= 0)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[--ptrA];
        }
        public int popStackB() throws IntStack.EmptyIntStackException {
            if (ptrB >= max-1)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[++ptrB];
        }

        // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
        public int peekStackA() throws IntStack.EmptyIntStackException {
            if (ptrA <= 0)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[ptrA - 1];
        }
        public int peekStackB() throws IntStack.EmptyIntStackException {
            if (ptrB >= max-1)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[ptrB+1];
        }

        // 스택에서 x를 찾아 인덱스(없으면 –1)를 반환
        public int searchStackA(int x) {
            for (int i = ptrA - 1; i >= 0; i--)                // 정상 쪽에서 선형 검색
                if (stk[i] == x)
                    return i;                                // 검색 성공
            return -1;                                        // 검색 실패
        }
        public int searchStackB(int x) {
            for (int i = ptrB +1 ; i < max; i++)                // 정상 쪽에서 선형 검색
                if (stk[i] == x)
                    return i;                                // 검색 성공
            return -1;                                        // 검색 실패
        }

        // 스택을 비움
        public void clearStackA() {
        	ptrA = 0;
        }
        public void clearStackB() {
        	ptrB = max-1;
        }

        // 스택의 용량을 반환
        public int capacity() {
            return max;
        }

        // 스택에 쌓여 있는 데이터 수를 반환
        public int sizeStackA() {
            return ptrA;
        }
        public int sizeStackB() {
            return max-ptrB-1;
        }

        // 스택이 비어 있는가?
        public boolean isEmptyStackA() {
            return ptrA <= 0;
        }
        public boolean isEmptyStackB() {
            return ptrB >= max-1;
        }

        // 스택이 가득 찼는가?
        public boolean isFull() {
            return ptrA-1 == ptrB;
        }

        // 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
        public void dump() {
        	System.out.println("0  1  2  3  4  5  6  7  8  9");
            if (ptrA <= 0)
                System.out.print("");
            else {
                for (int i = 0; i < ptrA; i++)
                    System.out.print(stk[i] + "  ");
            }
            if (ptrA != ptrB) {
                for (int i = 0; i <= (ptrB-ptrA); i++)
                    System.out.print("0  ");
            }
            if (ptrB >= max-1)
                System.out.print("");
            else {
            	for (int i = ptrB+1; i < max; i++)
                    System.out.print(stk[i] + "  ");
            }
            System.out.println();
        }
    };


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(10);	// 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("\n현재 데이터 수：" + (s.sizeStackA()+s.sizeStackB()) + " / "+ s.capacity());
            System.out.print("(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA\n"
            		+ "(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB\n"
            		+ "(11)덤프　(0)종료\n번호 :");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:// 푸시-StackA
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    if(s.isFull()){
                        System.out.println("스택이 가득 찼습니다.");
                        break;
                    }
                    s.pushStackA(x);
                    break;

                case 2:// 팝-StackA
                    if(s.isEmptyStackA()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.popStackA();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 3:// 피크-StackA
                    if(s.isEmptyStackA()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.peekStackA();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;

                case 4:// 검색-StackA
                    if(s.isEmptyStackA()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    System.out.print("검색할 데이터：");
                    x = stdIn.nextInt();
                    int idxA = s.searchStackA(x);
                    if(idxA == -1)
                        System.out.println("값이 존재하지 않습니다.");
                    else
                        System.out.println("검색한 데이터는 " + idxA + "에 위치합니다.");
                    break;
                case 5:// 비우기-StackA
                    s.clearStackA();
                    break;
                    
                case 6:// 푸시-StackB
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    if(s.isFull()){
                        System.out.println("스택이 가득 찼습니다.");
                        break;
                    }
                    s.pushStackB(x);
                    break;

                case 7:// 팝-StackB
                    if(s.isEmptyStackB()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.popStackB();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 8:// 피크-StackB
                    if(s.isEmptyStackB()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.peekStackB();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;

                case 9:// 검색-StackB
                    if(s.isEmptyStackB()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    System.out.print("검색할 데이터：");
                    x = stdIn.nextInt();
                    int idxB = s.searchStackB(x);
                    if(idxB == -1)
                        System.out.println("값이 존재하지 않습니다.");
                    else
                        System.out.println("검색한 데이터는 " + idxB + "에 위치합니다.");
                    break;
                case 10:// 비우기-StackB
                    s.clearStackB();
                    break;

                case 11:// 덤프
                    s.dump();
                    break;
            }
        }
    }

}

/*
print:
현재 데이터 수：0 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :1
데이터：1

현재 데이터 수：1 / 10
번호 :1
데이터：2

현재 데이터 수：2 / 10
번호 :1
데이터：3

현재 데이터 수：3 / 10
번호 :1
데이터：4

현재 데이터 수：4 / 10
번호 :1
데이터：5

현재 데이터 수：5 / 10
번호 :1
데이터：6

현재 데이터 수：6 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :6
데이터：7

현재 데이터 수：7 / 10
번호 :6
데이터：8

현재 데이터 수：8 / 10
번호 :6
데이터：9

현재 데이터 수：9 / 10
번호 :6
데이터：10

현재 데이터 수：10 / 10
(11)덤프
번호 :11
0  1  2  3  4  5  6  7  8  9
1  2  3  4  5  6  10  9  8  7  

현재 데이터 수：10 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
번호 :3
피크한 데이터는 6입니다.

현재 데이터 수：10 / 10
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
번호 :8
피크한 데이터는 10입니다.

현재 데이터 수：10 / 10
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
번호 :9
검색할 데이터：1
값이 존재하지 않습니다.

현재 데이터 수：10 / 10
번호 :9
검색할 데이터：10
검색한 데이터는 6에 위치합니다.

현재 데이터 수：10 / 10
번호 :9
검색할 데이터：7
검색한 데이터는 9에 위치합니다.

현재 데이터 수：10 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :7
팝한 데이터는 10입니다.

현재 데이터 수：9 / 10
번호 :7
팝한 데이터는 9입니다.

현재 데이터 수：8 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :10

현재 데이터 수：6 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :11
0  1  2  3  4  5  6  7  8  9
1  2  3  4  5  6  0  0  0  0  

현재 데이터 수：6 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :6
데이터：7

현재 데이터 수：7 / 10
번호 :6
데이터：8

현재 데이터 수：8 / 10
번호 :6
데이터：9

현재 데이터 수：9 / 10
번호 :6
데이터：9

현재 데이터 수：10 / 10
번호 :6
데이터：9
스택이 가득 찼습니다.

현재 데이터 수：10 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :5

현재 데이터 수：4 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :10

현재 데이터 수：0 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :11
0  1  2  3  4  5  6  7  8  9
0  0  0  0  0  0  0  0  0  0  

현재 데이터 수：0 / 10
(1)푸시-StackA  (2)팝-StackA  (3)피크-StackA  (4)검색-StackA  (5)비우기-StackA
(6)푸시-StackB  (7)팝-StackB  (8)피크-StackB  (9)검색-StackB  (10)비우기-StackB
(11)덤프　(0)종료
번호 :0
*/
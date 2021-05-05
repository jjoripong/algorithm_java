import java.util.Scanner;

public class practice01 {
    static public class IntStack {
        private int max;            // 스택 용량
        private int ptr;            // 스택 포인터
        private int[] stk;            // 스택 본체

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
            ptr = 0;
            max = capacity;
            try {
                stk = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        // 스택에 x를 푸시
        public int push(int x) throws IntStack.OverflowIntStackException {
            if (ptr >= max)// 스택이 가득 참
                throw new IntStack.OverflowIntStackException();
            return stk[ptr++] = x;
        }

        // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
        public int pop() throws IntStack.EmptyIntStackException {
            if (ptr <= 0)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[--ptr];
        }

        // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
        public int peek() throws IntStack.EmptyIntStackException {
            if (ptr <= 0)// 스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            return stk[ptr - 1];
        }

        // *스택에서 x를 찾아 인덱스(없으면 –1)를 반환
        public int indexOf(int x) {
            for (int i = ptr - 1; i >= 0; i--)                // 정상 쪽에서 선형 검색
                if (stk[i] == x)
                    return i;                                // 검색 성공
            return -1;                                        // 검색 실패
        }

        // *스택을 비움
        public void clear() {
            ptr = 0;
        }

        // 스택의 용량을 반환
        public int capacity() {
            return max;
        }

        // 스택에 쌓여 있는 데이터 수를 반환
        public int size() {
            return ptr;
        }

        // *스택이 비어 있는가?
        public boolean isEmpty() {
            return ptr <= 0;
        }

        // *스택이 가득 찼는가?
        public boolean isFull() {
            return ptr >= max;
        }

        // 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
        public void dump() {
            if (ptr <= 0)
                System.out.println("스택이 비어 있습니다.");
            else {
                for (int i = 0; i < ptr; i++)
                    System.out.print(stk[i] + " ");
                System.out.println();
            }
        }
    };


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);	// 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("\n현재 데이터 수：" + s.size() + " / "+ s.capacity());
            System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프　\n(5)검색  (6)비우기  (0)종료\n번호 :");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:// 푸시
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    if(s.isFull()){
                        System.out.println("스택이 가득 찼습니다.");
                        break;
                    }
                    s.push(x);
                    break;

                case 2:// 팝
                    if(s.isEmpty()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.pop();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 3:// 피크
                    if(s.isEmpty()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    x = s.peek();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;

                case 4:// 덤프
                    s.dump();
                    break;
                case 5:// 검색 --- 추가
                    if(s.isEmpty()){
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    System.out.print("검색할 데이터：");
                    x = stdIn.nextInt();
                    int idx = s.indexOf(x);
                    if(idx == -1)
                        System.out.println("값이 존재하지 않습니다.");
                    else
                        System.out.println("검색한 데이터는 " + idx + "에 위치합니다.");
                    break;
                case 6:// 비우기 --- 추가
                    s.clear();
                    break;
            }
        }
    }

}

/*
print:
현재 데이터 수：0 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :1
데이터：12

현재 데이터 수：1 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :1
데이터：24

현재 데이터 수：2 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :1
데이터：36

현재 데이터 수：3 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :2
팝한 데이터는 36입니다.

현재 데이터 수：2 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :1
데이터：48

현재 데이터 수：3 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :1
데이터：60

현재 데이터 수：4 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :3
피크한 데이터는 60입니다.

현재 데이터 수：4 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :4
12 24 48 60

현재 데이터 수：4 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :5
검색할 데이터：24
검색한 데이터는 1에 위치합니다.

현재 데이터 수：4 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :5
검색할 데이터：36
값이 존재하지 않습니다.

현재 데이터 수：4 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :6

현재 데이터 수：0 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :4
스택이 비어 있습니다.

현재 데이터 수：0 / 64
(1)푸시  (2)팝  (3)피크  (4)덤프　
(5)검색  (6)비우기  (0)종료
번호 :0
*/
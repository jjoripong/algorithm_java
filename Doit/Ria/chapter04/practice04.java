import java.util.Scanner;

public class practice04 {
    static public class IntAryQueue {
        private int max;            // 큐 용량
        private int num;            // 큐 size
        private int[] que;            // 큐 본체

        // 실행 시 예외 : 큐 비어 있음
        public class EmptyIntAryQueueException extends RuntimeException {
            public EmptyIntAryQueueException() {
            }
        }

        // 실행 시 예외 : 큐 가득 참
        public class OverflowIntAryQueueException extends RuntimeException {
            public OverflowIntAryQueueException() {
            }
        }

        // 생성자
        public IntAryQueue(int capacity) {
            num = 0;
            max = capacity;
            try {
                que = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        // 큐에 x를 푸시
        public int enqueue(int x) throws IntAryQueue.OverflowIntAryQueueException {
            if (num >= max)// 큐이 가득 참
                throw new IntAryQueue.OverflowIntAryQueueException();
            return que[num++] = x;
        }

        // 큐에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
        public int dequeue() throws IntAryQueue.EmptyIntAryQueueException {
            if (num <= 0)// 큐이 비어 있음
                throw new IntAryQueue.EmptyIntAryQueueException();
            int dequeueData = que[0];
            for(int idx = 0; idx < num-1; idx++)
                que[idx] = que[idx+1];
            num--;
            return dequeueData;
        }

        // 큐에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
        public int peek() throws IntAryQueue.EmptyIntAryQueueException {
            if (num <= 0)// 큐이 비어 있음
                throw new IntAryQueue.EmptyIntAryQueueException();
            return que[0];
        }

        // 큐에서 x를 찾아 인덱스(없으면 –1)를 반환
        public int indexOf(int x) {
            for (int i = num - 1; i >= 0; i--)                // 정상 쪽에서 선형 검색
                if (que[i] == x)
                    return i;                                // 검색 성공
            return -1;                                        // 검색 실패
        }

        // 큐을 비움
        public void clear() {
            num = 0;
        }

        // 큐의 용량을 반환
        public int capacity() {
            return max;
        }

        // 큐에 쌓여 있는 데이터 수를 반환
        public int size() {
            return num;
        }

        // 큐가 비어 있는가?
        public boolean isEmpty() {
            return num <= 0;
        }

        // 큐가 가득 찼는가?
        public boolean isFull() {
            return num >= max;
        }

        // 큐 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
        public void dump() {
            if (num <= 0)
                System.out.println("큐이 비어 있습니다.");
            else {
                for (int i = 0; i < num; i++)
                    System.out.print(que[i] + " ");
                System.out.println();
            }
        }
    };


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntAryQueue s = new IntAryQueue(64);	// 최대 64개를 푸시할 수 있는 큐

        while (true) {
            System.out.println("\n현재 데이터 수：" + s.size() + " / "+ s.capacity());
            System.out.print("(1)enqueue  (2)dequeue  (3)peek  (4)dump　\n(5)search  (6)clear  (0)end\n번호 :");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:// enqueue
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    if(s.isFull()){
                        System.out.println("큐가 가득 찼습니다.");
                        break;
                    }
                    s.enqueue(x);
                    break;

                case 2:// dequeue
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.dequeue();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 3:// 피크
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.peek();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;

                case 4:// 덤프
                    s.dump();
                    break;
                case 5:// 검색
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
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
                case 6:// 비우기
                    s.clear();
                    break;
            }
        }
    }

}

/*
print:
현재 데이터 수：0 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (0)end
번호 :1
데이터：1

현재 데이터 수：1 / 64
번호 :1
데이터：2

현재 데이터 수：2 / 64
번호 :1
데이터：3

현재 데이터 수：3 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (0)end
번호 :2
팝한 데이터는 1입니다.

현재 데이터 수：2 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (0)end
번호 :3
피크한 데이터는 2입니다.

현재 데이터 수：2 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (0)end
번호 :4
2 3 

현재 데이터 수：2 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (0)end
번호 :5
검색할 데이터：3
검색한 데이터는 1에 위치합니다.
*/

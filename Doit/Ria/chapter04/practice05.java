import java.util.Scanner;

public class practice05 {

    public static class IntQueue {
        private int max;			// 큐의 용량
        private int front;			// 첫 번째 요소 커서
        private int rear;			// 마지막 요소 커서
        private int num;			// 현재 데이터 수
        private int[] que;			// 큐 본체

        // 실행 시 예외：큐가 비어 있음
        public class EmptyIntQueueException extends RuntimeException {
            public EmptyIntQueueException() { }
        }

        // 실행 시 예외：큐가 가득 참
        public class OverflowIntQueueException extends RuntimeException {
            public OverflowIntQueueException() { }
        }

        // 생성자
        public IntQueue(int capacity) {
            num = front = rear = 0;
            max = capacity;
            try {
                que = new int[max];				// 큐 본체용 배열을  생성
            } catch (OutOfMemoryError e) {		// 생성할 수 없음
                max = 0;
            }
        }

        // 큐에 데이터를 인큐
        public int enque(int x) throws OverflowIntQueueException {
            if (num >= max)
                throw new OverflowIntQueueException();			// 큐가 가득 참
            que[rear++] = x;
            num++;
            if (rear == max)
                rear = 0;
            return x;
        }

        // 큐에서 데이터를 디큐
        public int deque() throws EmptyIntQueueException {
            if (num <= 0)
                throw new EmptyIntQueueException();				// 큐가 비어 있음
            int x = que[front++];
            num--;
            if (front == max)
                front = 0;
            return x;
        }

        // 큐에서 데이터를 피크 (프런트 데이터를 들여다봄)
        public int peek() throws EmptyIntQueueException {
            if (num <= 0)
                throw new EmptyIntQueueException();				// 큐가 비어 있음
            return que[front];
        }

        // 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환
        public int indexOf(int x) {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % max;
                if (que[idx] == x)								// 검색 성공
                    return idx;
            }
            return -1;											// 검색 실패
        }

        // 큐를 비움
        public void clear() {
            num = front = rear = 0;
        }

        // 큐의 용량을 반환
        public int capacity() {
            return max;
        }

        // 큐에 쌓여 있는 데이터 수를 반환
        public int size() {
            return num;
        }

        // 큐가 비어 있나요?
        public boolean isEmpty() {
            return num <= 0;
        }

        // 큐가 가득 찼나요?
        public boolean isFull() {
            return num >= max;
        }

        // 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력
        public void dump() {
            if (num <= 0)
                System.out.println("큐가 비어 있습니다.");
            else {
                for (int i = 0; i < num; i++)
                    System.out.print(que[(i + front) % max] + " ");
                System.out.println();
            }
        }

        // 큐에서 x를 검색하여 위치(찾지 못하면 0)를 반환
        public int search(int x) {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % max;
                if (que[idx] == x)								// 검색 성공
                    return i+1;
            }
            return 0;											// 검색 실패
        }
    };


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue s = new IntQueue(64);	// 최대 64개를 푸시할 수 있는 큐

        while (true) {
            System.out.println("\n현재 데이터 수：" + s.size() + " / "+ s.capacity());
            System.out.print("(1)enqueue  (2)dequeue  (3)peek  (4)dump　\n(5)search  (6)clear  (7)몇번째? (0)end\n번호 :");

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
                    s.enque(x);
                    break;

                case 2:// dequeue
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.deque();
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
                case 7:// 몇번째?
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    System.out.print("검색할 데이터：");
                    x = stdIn.nextInt();
                    int location = s.search(x);
                    if(location == 0)
                        System.out.println("값이 존재하지 않습니다.");
                    else
                            System.out.println("검색한 데이터는 " + location + "번째!");
                    break;
            }
        }
    }

}

/*
print:
현재 데이터 수：0 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :1
데이터：1

현재 데이터 수：1 / 64
데이터：2

현재 데이터 수：2 / 64
데이터：3

현재 데이터 수：3 / 64
데이터：4

현재 데이터 수：4 / 64
데이터：5

현재 데이터 수：5 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :2
팝한 데이터는 1입니다.

현재 데이터 수：4 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :2
팝한 데이터는 2입니다.

현재 데이터 수：3 / 64
데이터：6

현재 데이터 수：4 / 64
데이터：7

현재 데이터 수：5 / 64
데이터：8

현재 데이터 수：6 / 64
데이터：9

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :4
3 4 5 6 7 8 9 

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :5
검색할 데이터：3
검색한 데이터는 2에 위치합니다.

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :5
검색할 데이터：7
검색한 데이터는 6에 위치합니다.

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :7
검색할 데이터：3
검색한 데이터는 1번째!

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :7
검색할 데이터：10
값이 존재하지 않습니다.

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :7
검색할 데이터：7
검색한 데이터는 5번째!

현재 데이터 수：7 / 64
(1)enqueue  (2)dequeue  (3)peek  (4)dump　
(5)search  (6)clear  (7)몇번째? (0)end
번호 :4
3 4 5 6 7 8 9 
*/
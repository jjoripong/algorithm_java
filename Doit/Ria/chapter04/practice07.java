import java.util.Scanner;

public class practice07 {

    public static class IntDeque {
        private int max;			// 큐의 용량
        //private int front;			// 첫 번째 요소 커서
        //private int rear;			// 마지막 요소 커서
        //private int frontB;			// 첫 번째 요소 커서
        //private int rearB;			// 마지막 요소 커서
        private int num;			// 현재 데이터 수
        private int[] que;			// 큐 본체

        // 실행 시 예외：큐가 비어 있음
        public class EmptyIntDequeException extends RuntimeException {
            public EmptyIntDequeException() { }
        }

        // 실행 시 예외：큐가 가득 참
        public class OverflowIntDequeException extends RuntimeException {
            public OverflowIntDequeException() { }
        }

        // 생성자
        public IntDeque(int capacity) {
            num = 0;
            max = capacity;
            try {
                que = new int[max];				// 큐 본체용 배열을  생성
            } catch (OutOfMemoryError e) {		// 생성할 수 없음
                max = 0;
            }
        }

        // 큐에 데이터를 인큐
        public int enqueFront(int x) throws OverflowIntDequeException {
            if (num >= max)
                throw new OverflowIntDequeException();			// 큐가 가득 참
            for(int idx = 0; idx < num; idx++)
                que[idx+1] = que[idx];
            que[0] = x;
            num++;
            return x;
        }
        public int enqueRear(int x) throws OverflowIntDequeException {
            if (num >= max)
                throw new OverflowIntDequeException();			// 큐가 가득 참
            que[num++] = x;
            return x;
        }

        // 큐에서 데이터를 디큐
        public int dequeFront() throws EmptyIntDequeException {
            if (num <= 0)// 큐이 비어 있음
                throw new EmptyIntDequeException();
            int x = que[0];
            for(int idx = 0; idx < num-1; idx++)
                que[idx] = que[idx+1];
            num--;
            return x;
        }
        public int dequeRear() throws EmptyIntDequeException {
            if (num <= 0)
                throw new EmptyIntDequeException();				// 큐가 비어 있음
            int x = que[num--];
            return x;
        }

        // 큐에서 데이터를 피크 (프런트 데이터를 들여다봄)
        public int peekFront() throws EmptyIntDequeException {
            if (num <= 0)
                throw new EmptyIntDequeException();				// 큐가 비어 있음
            return que[0];
        }
        public int peekRear() throws EmptyIntDequeException {
            if (num <= 0)
                throw new EmptyIntDequeException();				// 큐가 비어 있음
            return que[num-1];
        }

        // 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환
        public int indexOf(int x) {
        	 for (int i = 0; i < num; i++)                // 정상 쪽에서 선형 검색
                 if (que[i] == x)
                     return i;                                // 검색 성공
             return -1;										// 검색 실패
        }

        // 큐를 비움
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
        IntDeque s = new IntDeque(64);	// 최대 64개를 푸시할 수 있는 큐

        while (true) {
            System.out.println("\n현재 데이터 수：" + s.size() + " / "+ s.capacity());
            System.out.print("(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  \n(7)dump　(8)search  (9)clear  (0)end\n번호 :");

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
                    s.enqueFront(x);
                    break;

                case 2:// dequeue
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.dequeFront();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 3:// 피크
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.peekFront();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;
                    
                case 4:// enqueue
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    if(s.isFull()){
                        System.out.println("큐가 가득 찼습니다.");
                        break;
                    }
                    s.enqueRear(x);
                    break;

                case 5:// dequeue
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.dequeRear();
                    System.out.println("팝한 데이터는 " + x + "입니다.");
                    break;

                case 6:// 피크
                    if(s.isEmpty()){
                        System.out.println("큐가 비어 있습니다.");
                        break;
                    }
                    x = s.peekRear();
                    System.out.println("피크한 데이터는 " + x + "입니다.");
                    break;                    

                case 7:// 덤프
                    s.dump();
                    break;
                case 8:// 검색
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
                case 9:// 비우기
                    s.clear();
                    break;
            }
        }
    }

}

/*
print:
현재 데이터 수：0 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :1
데이터：1

현재 데이터 수：1 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :1
데이터：2

현재 데이터 수：2 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :4
데이터：4

현재 데이터 수：3 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :4
데이터：5

현재 데이터 수：4 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :7
2 1 4 5 

현재 데이터 수：4 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :3
피크한 데이터는 2입니다.

현재 데이터 수：4 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :6
피크한 데이터는 5입니다.

현재 데이터 수：4 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :2
팝한 데이터는 2입니다.

현재 데이터 수：3 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :5
팝한 데이터는 5입니다.

현재 데이터 수：2 / 64
(1)enqueue맨 앞  (2)dequeue맨 앞  (3)peek맨 앞  (4)enqueue맨 뒤  (5)dequeue맨 뒤  (6)peek맨 뒤  
(7)dump　(8)search  (9)clear  (0)end
번호 :9
*/
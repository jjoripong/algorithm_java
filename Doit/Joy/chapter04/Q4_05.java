
public class IntQueue {
	
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;
    
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
			// TODO Auto-generated constructor stub
		}
    }

    public class EmptyIntQueueException extends RuntimeException {
    	public EmptyIntQueueException() {
			// TODO Auto-generated constructor stub
		}
    }
    
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }
    
    public int enqueue(int x) throws OverflowIntQueueException {
        if (num >= max) // 큐 내부 데이터 수가 용량보다 클 경우
            throw new OverflowIntQueueException();
        // rear자리에 데이터 넣고 증가
        que[rear++] = x;
        num++;  // 큐 내부 데이터 수 증가
        // rear와 max 값이 같아지는 것을 방지하기 위해 최대값 위치를 넘어갈 경우 다시 0으로 set
        if(rear == max)
            rear = 0;
        return x;
    }
    
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        // 큐 front 위치에서 값 가져오고 front 위치 이동
        int x = que[front++];
        num--;
        // front와 max가 같아지는 것을 방지(링형 구조)
        if (front == max)
            front = 0;
        return x;
    }
    
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }
    
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            // front(시작이 0이 아닐 수 있음) to rear 선형 검색
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    } 
    
	public void clear() {
        num = front = rear = 0;
    }
    
    public int capacity() {
    	return max;
    }
        
    public int size() {
        return num;
    }
    
 	public boolean isEmpty() {
        return num <= 0;
    }
    
    public boolean isFull() {
        return num >= max;
    }
    
  	public void dump() {
        if (num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i+front) % max] + "");
            System.out.println();
        }
    }
  	
  	// 큐 안에 몇 번째에 있는가
  	// front : 0 
  	// 검색 실패 시 0반환
  	public int search(int x) {
  		for (int i=0; i < num; i++) {
  			if (que[(i+front) % max] == x) 
  				return i+1;
  		}
  		return 0;
  	}
    
}

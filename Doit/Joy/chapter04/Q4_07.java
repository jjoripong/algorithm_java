
// 선형 큐 만들기
public class CircularDeque {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] dque;
    
    public class OverflowDeQueueException extends RuntimeException {
        public OverflowDeQueueException() {
			// TODO Auto-generated constructor stub
		}
    }

    public class EmptyDeQueueException extends RuntimeException {
    	public EmptyDeQueueException() {
			// TODO Auto-generated constructor stub
		}
    }
    
    public CircularDeque(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            dque = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int addFront(int x) throws OverflowDeQueueException {
    	if (num >= max) 
    		throw new OverflowDeQueueException();
    	dque[front] = x;
    	num++;
    	// 반시계 방향 연산
    	front = (front -1 + max) % max;
    	return x;
    }
    
    // dequeue
    public int deleteFront() throws EmptyDeQueueException {
    	if (num <= 0)
    		throw new EmptyDeQueueException();
    	int x = dque[front++];
    	num--;
        if (front == max)
            front = 0;
        return x;
    }
    
    public int getFront() throws EmptyDeQueueException {
        if (num <= 0)
            throw new EmptyDeQueueException();
        return dque[front];
    }
    
    // enqueue
    public int addRear(int x) throws OverflowDeQueueException {
    	if (num >= max)
    		throw new EmptyDeQueueException();
    	dque[rear++] = x;
    	num++;
        if(rear == max)
            rear = 0;
        return x;
    }
    
    public int deleteRear() throws EmptyDeQueueException {
    	if (num <= 0)
            throw new EmptyDeQueueException();

    	int x = dque[rear];
    	num--;
    	// 반시계 방향 연산
    	rear = (rear-1+max)%max;
    	return x;
    }
    
    public int getRear() throws EmptyDeQueueException {
        if (num <= 0)
            throw new EmptyDeQueueException();
        return dque[rear];
    }
    
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            // front(시작이 0이 아닐 수 있음) to rear 선형 검색
            int idx = (i + front) % max;
            if (dque[idx] == x)
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
                System.out.print(dque[(i+front) % max] + "");
            System.out.println();
        }
    }
  	
  	// 큐 안에 몇 번째에 있는가
  	// front : 0 
  	// 검색 실패 시 0반환
  	public int search(int x) {
  		for (int i=0; i < num; i++) {
  			if (dque[(i+front) % max] == x) 
  				return i+1;
  		}
  		return 0;
  	}
    
	
}

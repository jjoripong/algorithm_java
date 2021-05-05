import IntQueue.EmptyIntQueueException;
import IntQueue.OverflowIntQueueException;

// idx 맨 앞부터 데이터 쌓임
// 나갈때 맨 앞부터 나가고, 남아있는 데이터는 하나씩 idx 앞으로 이동
// 데이터가 3개 있으면 idx 0~2까지 차있음
public class IntAryQueue {
	
    private int max;
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
    
    public IntAryQueue(int capacity) {
        num = 0;
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
        que[num++] = x;
        return x;
    }
    
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        // 큐 front 위치에서 값 가져오고 front 위치 이동
        int x = que[0];
        for (int i=0; i < num-1; i++) {
        	que[i] = que[i+1];
        }
        num--;
        return x;
    }

    // 꼭대기가 맨뒤야 맨앞이야?
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[num-1];
    }
    
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[i] == x)
                return i;
        }
        return -1;
    } 
    
	public void clear() {
        num = 0;
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
                System.out.print(que[i] + "");
            System.out.println();
        }
    }
    
}

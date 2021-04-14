

public class Gstack<T> {

	private int max;
	private int ptr;
	private T[] stk;
	
//	// 예외 : 빈 스택
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
			// TODO Auto-generated constructor stub
		}
	}
//	
//	// 예외 : 가득찬 스택
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
			// TODO Auto-generated constructor stub
		}
	}
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
            // Object로 생성해서 T 타입으로 변환
			stk = (T[]) new Object[max];	// 스택 생성
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public T push(T x) throws OverflowGstackException {
		if (ptr >= max) 
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}
	
	public T pop() throws EmptyGstackException {
		if (ptr <= 0) 
			throw new EmptyGstackException();
		return stk[--ptr];
	}
	
	public T peek() throws EmptyGstackException {
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}
	
    public int indexOf(T x) {
        for (int i = ptr-1; i >= 0 ; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    // 스택 용량 반환
    public int capacity() {
        return max;
    }

    // 스택에 쌓인 데이터 수 반환
    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr > max;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {ㄴ
        	System.out.print("데이터: ");
            for (int i=0; i< ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
    
}

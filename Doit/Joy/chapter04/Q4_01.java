import java.util.Scanner;

public class IntStack {
	private int max; // 스택 용량
	private int ptr; // 스택 포인터: 스택에 쌓인 데이터 수를 나타냄
	private int[] stk; // 스택
	
	// 예외 : 빈 스택
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			// TODO Auto-generated constructor stub
		}
	}
	
	// 예외 : 가득찬 스택
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			// TODO Auto-generated constructor stub
		}
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];	// 스택 생성
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max) 
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) 
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
    public int indexOf(int x) {
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
        else {
        	System.out.print("데이터: ");
            for (int i=0; i< ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
    
    public static void main(String args[]) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.printf("현재 데이터 수: %d / %d \n", s.size(), s.capacity());
            System.out.print("1. 푸시 2. 팝 3. 피크 4. 덤프 5. 검색 6. 전체 삭제 7. 스택 용량 0. 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                	System.out.print("데이터: ");
                	x = stdIn.nextInt();
                	try {
                		s.push(x);
                	} catch (IntStack.OverflowIntStackException e) {
                		System.out.println("스택이 가득 찼습니다.");
                	}
                    break;
                case 2:
                	try {
                		x = s.pop();
                		System.out.println("팝한 데이터는: " + x + " 입니다.");
                	} catch(IntStack.EmptyIntStackException e) {
                		System.out.println("스택이 비어 있습니다.");
                	}
                    break;
                case 3:
                	try {
                		x = s.peek();
                		System.out.printf("피크한 데이터는 %d입니다.\n", x);
                	} catch (IntStack.EmptyIntStackException e) {
                		System.out.println("스택이 비어 있습니다.");
                	}
                    break;
                case 4:
                	s.dump();
                    break;
                case 5:
                	System.out.println("검색을 원하는 값을 입력하세요.: ");
                	int i = stdIn.nextInt();
                	int value = s.indexOf(i);
                	if (value != -1) System.out.printf("찾으시는 값은 인덱스 %d에 있습니다.\n", value);
                	else System.out.println("값을 찾을 수 없습니다.");
                	break;
                case 6:
                	s.clear();
                	System.out.println("전제 삭제가 완료 되었습니다.");
                	break;
                case 7:
                	System.out.printf("스택의 용량은 %d입니다.\n", s.capacity());
                	break;
            }
        }
    }

}

import java.util.Scanner;

public class TwoInOneStack {

	/*
	 * a              b
	 * [0][][][][a-1][a]...[b-1]
	 *            ^   ^
	 *           pop pop
	 * a: 0 ~a-1  / aMax : a-1
	 * b: b-1 ~ a / bMax : a
	 */
	
	private int aMax, bMax;
	private int aPtr, bPtr;
	private int stk[];
	
	// 참고
	public enum StackType {
		StackA, StackB
	};
	
	public TwoInOneStack(int aCapacity, int bCapacity) {
		aPtr = 0;
		aMax = aCapacity;
		bMax = aCapacity + bCapacity;
		bPtr = bMax-1;
		
		try {
			stk = new int[aMax+bMax];	// 스택 생성
		} catch (OutOfMemoryError e) {
			aMax = 0;
			bMax = 0;
		}
	}
	
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
	
	public int push(StackType t,int x) throws OverflowIntStackException {
		switch (t) {
			case StackA: 
				if (aPtr >= aMax) 
					throw new OverflowIntStackException();
				return stk[aPtr++] = x;
			case StackB: 
				if (bPtr >= aMax) 
					throw new OverflowIntStackException();
				return stk[bPtr++] = x;	
			default: 
				throw new IllegalArgumentException("Unexpected Type: " + t);
		}
	}
	
	public int pop(StackType t) throws EmptyIntStackException {
		switch (t) {
			case StackA: 
				if (aPtr <= 0) 
					throw new EmptyIntStackException();
				return stk[--aPtr];
			case StackB: 
				if (bPtr <= bMax) 
					throw new EmptyIntStackException();
				return stk[++bPtr];
			default: 
				throw new IllegalArgumentException("Unexpected Type: " + t);
		}
	}

	
	public int peek(StackType t) throws EmptyIntStackException {
		switch (t) {
			case StackA: 
				if (aPtr <= 0)
					throw new EmptyIntStackException();
				return stk[aPtr-1];
			case StackB: 
				if (bPtr <= bMax) 
					throw new EmptyIntStackException();
				return stk[bPtr-1];
			default: 
				throw new IllegalArgumentException("Unexpected Type: " + t);
		}
	}
	
    public int indexOf(int x) {
    	for (int i = bPtr-1; i >= 0 ; i--)
    		if (stk[i] == x)
    			return i;
		return -1;
    }

    public void clear() {
    	aPtr = 0;
    	bPtr = bMax-1;
    }

    // 스택 용량 반환
    public int capacity(StackType t) {
    	switch (t) {
		case StackA: 
			return aMax;
		case StackB: 
			return bMax - aMax;
		default:
			throw new IllegalArgumentException("Unexpected Type: " + t);
		}
    }

    // 스택에 쌓인 데이터 수 반환
    public int size(StackType t) {
    	switch (t) {
		case StackA: 
			return aPtr;
		case StackB: 
			return aMax - bPtr;
		default:
			throw new IllegalArgumentException("Unexpected Type: " + t);
		}
    }

    public boolean isEmpty(StackType t) {
    	switch (t) {
		case StackA: 
			return aPtr <= 0;
		case StackB: 
			return bPtr <= aPtr;
		default:
			throw new IllegalArgumentException("Unexpected Type: " + t);
		}
    }

    public boolean isFull(StackType t) {
    	switch (t) {
		case StackA: 
			return aPtr > aMax;
		case StackB: 
			return bPtr > bMax;
		default:
			throw new IllegalArgumentException("Unexpected Type: " + t);
		}
    }

    public void dump() {
        if (aPtr <= 0)
            System.out.println("A스택이 비어 있습니다.");
        else {
        	System.out.print("* A스택 데이터: ");
            for (int i=0; i< aPtr; i++) 
                System.out.print(stk[i] + " ");
            System.out.println();
        }
        if (bPtr <= aMax) 
            System.out.println("B스택이 비어 있습니다.");
        else {
        	System.out.print("* B스택 데이터: ");
            for (int i= bPtr-1; i >= aMax; i--)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
    
    public static StackType mapToStackType(int t) {
    	if (t == 0) return StackType.StackA;
    	else return StackType.StackB;
    }
    
    public static void main(String args[]) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("A스택 용량을 입력해주세요: ");
        int aSize = stdIn.nextInt();
        System.out.println("B스택 용량을 입력해주세요: ");
        int bSize = stdIn.nextInt();
        TwoInOneStack s = new TwoInOneStack(aSize, bSize);

        while (true) {
            System.out.printf("A스택 현재 데이터 수: %d / %d \n", s.size(StackType.StackA), s.capacity(StackType.StackA));
            System.out.printf("B스택 현재 데이터 수: %d / %d \n", Math.abs(s.size(StackType.StackB)), s.capacity(StackType.StackB));
            System.out.print("1. 푸시 2. 팝 3. 피크 4. 덤프 5. 검색 6. 전체 삭제 7. 스택 용량 0. 종료: ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x, t;
            
            switch (menu) {
                case 1:
                	System.out.println("어떤 스택에 push하시겠습니까? 0. StackA 1. StackB");
                	t = stdIn.nextInt();
                	System.out.print("데이터: ");
                	x = stdIn.nextInt();
                	try {
                		s.push(mapToStackType(t), x);
                	} catch (TwoInOneStack.OverflowIntStackException e) {
                		System.out.println("스택이 가득 찼습니다.");
                	}
                    break;
                case 2:
                	try {
                    	System.out.println("어떤 스택에서 pop하시겠습니까? 0. StackA 1. StackB");
                    	t = stdIn.nextInt();
                		x = s.pop(mapToStackType(t));
                		System.out.println("팝한 데이터는: " + x + " 입니다.");
                	} catch(TwoInOneStack.EmptyIntStackException e) {
                		System.out.println("스택이 비어 있습니다.");
                	}
                    break;
                case 3:
                	try {
                    	System.out.println("어떤 스택에서 peek하시겠습니까? 0. StackA 1. StackB");
                    	t = stdIn.nextInt();
                		x = s.peek(mapToStackType(t));
                		System.out.printf("피크한 데이터는 %d입니다.\n", x);
                	} catch (TwoInOneStack.EmptyIntStackException e) {
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
                	System.out.println("어떤 스택의 용량을 보시겠습니까? 0. StackA 1. StackB");
                	t = stdIn.nextInt();
                	System.out.printf("스택의 용량은 %d입니다.\n", s.capacity(mapToStackType(t)));
                	break;
            }
        }
    }

    
}

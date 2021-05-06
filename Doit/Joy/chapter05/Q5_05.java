    import java.util.Stack;

public static class Q5_05 {
    
    public void recur() {
        int n = 4;
        int status = 0;
        Stack<Integer> numStk = new Stack<>();
        Stack<Integer> statusStk = new Stack<>();

        // 재귀 실행 여부 0 : 재귀문 실행 x 1: recur(n-1) 실행 완료 2: recur(n-2) 실행 완료
        // recur(n-1) 실행 전. 데이터 push 필요
        while (true) {
            while (n > 0 && status == 0) {
                numStk.push(n);
                n = n-1;
                // 실행 완료 후 status 1로 변경
                statusStk.push(1);
            }
            if (!numStk.isEmpty()) {
                n = numStk.pop();
                status = statusStk.pop();

                if ((n - 2) >= 1 && status == 1) {
                    status = 2;
                    numStk.push(n);
                    statusStk.push(status);

                    n = n -2;
                    status = 0;
                } else System.out.println(n);
                continue;
            }
            break;
        }
    }
}    

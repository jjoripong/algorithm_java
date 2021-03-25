 //1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 출력
public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("1부터 n까지의 합을 구합니다.");
    System.out.println("n의 값 : ");
    int n = stdIn.nextInt();

    int sum = 0;
    for (int i = 1; i <= n; i++){
        sum += i;
        if(i == 1)
            System.out.print(i);
        else
            System.out.print(" + " +i);
    }
    System.out.print(" = " + sum);
}
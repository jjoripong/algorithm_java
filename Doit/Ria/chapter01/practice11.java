public class practice11 {

    //양의 정수 자릿수 구하기
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양의 정수 : ");
        int a = stdIn.nextInt();

        String aToString = Integer.toString(a);

        System.out.println("그 수는"+ aToString.length() +"자리 입니다.");
    }
}
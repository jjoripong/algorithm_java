//세 값의 최솟겂
static int min3(int a, int b, int c){
    int min = a;

    if (min > b){
        min = b;
    }
    if (min > c){
        min = c;
    }
    return min;
}

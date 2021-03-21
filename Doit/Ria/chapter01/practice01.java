//네 값의 최대값
static int max4(int a, int b, int c, int d){
    int max = a;

    if (max < b){
        max = b;
    }
    if (max < c){
        max = c;
    }
    if (max < d){
        max = d;
    }
    return max;
}
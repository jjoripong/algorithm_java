static int med3(int a,  int b, int c){
    if((b>=a && c<=a) || (b<=a && c>=a))
        return a;
    else if((a>b && c<b) && (a<b && c>b))
        return b;
    return c;
}
//한번 비교하는데 시간이 오래 걸린다.
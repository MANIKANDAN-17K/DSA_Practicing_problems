class Solution {
    static int power(int x,int y){
        if(y == 0) return 1;
        if(y %2 == 0)
            return power(x,y/2) * power(x,y/2);
        return x * power(x,y/2) * power(x,y/2);
    }
    static int order(int n){
        int t = 0;
        while(n != 0){
            t++;
            n/=10;
        }
        return t;
    }
    static boolean armstrongNumber(int n) {
        int sum = 0;
        int x = order(n);
        int temp = n;
        while(temp != 0){
            int r = temp % 10;
            sum += power(r,x);
            temp /= 10;
        }
        return n == sum;
    }
}

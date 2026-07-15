class Solution {
    public static int gcdHelper(int a,int b){
        return (b == 0 ? a : gcdHelper(b,a%b));
    }
    public static int gcd(int a, int b) {
        return gcdHelper(a,b);
    }
}

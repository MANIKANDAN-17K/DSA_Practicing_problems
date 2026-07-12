class Solution {
    public boolean isPalindrome(int n) {
        int rev = 0;
        int temp = Math.abs(n);
        while(temp != 0){
            rev *= 10;
            rev += temp % 10;
            temp /= 10;
        }
        return rev == Math.abs(n);
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 1;
        int r = n - 2;
        int lm = height[l-1];
        int rm = height[r+1];
        int res = 0;
        while(l <= r){
            if(rm <= lm){
                res += Math.max(0,rm - height[r]);
                rm = Math.max(rm,height[r]);
                r--;
            }else{
                res += Math.max(0,lm - height[l]);
                lm = Math.max(lm,height[l]);
                l++;
            }
        }
        return res;
    }
}

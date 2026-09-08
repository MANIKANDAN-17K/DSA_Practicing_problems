class Solution {
    public int maxWater(int arr[]) {
        int l = 1;
        int n = arr.length;
        int r = n - 2;
        int lm = arr[l-1];
        int rm = arr[r + 1];
        int res = 0;
        while(l <= r){
            if(rm <= lm){
                res += Math.max(0,rm - arr[r]);
                rm = Math.max(rm,arr[r]);
                r--;
            }else{
                res += Math.max(0,lm - arr[l]);
                lm = Math.max(lm,arr[l]);
                l++;
            }
        }
        return res;
    }
}

class Solution {
    static int longSeq(int[] arr,int idx,int[] dp){
        if(idx == 0) return 1;
        if(dp[idx] != -1) return dp[idx];
        int mx = 1;
        for(int prev = 0;prev < idx;prev++){
            if(arr[idx] > arr[prev]){
                mx = Math.max(mx,longSeq(arr,prev,dp) + 1);
            }
        }
        dp[idx] = mx;
        return dp[idx];
    }
    static int lis(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int res = 1;
        for(int i = 1;i<n;i++){
            res = Math.max(res,longSeq(arr,i,dp));
        }
        return res;
    }
}

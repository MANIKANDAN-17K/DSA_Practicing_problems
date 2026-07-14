class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        for(int i = 2;i<=n;i++){
            dp[i] = Math.max(arr[i-1] + dp[i-2],dp[i-1]);
        }
        return dp[n];
    }
}

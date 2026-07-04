class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = n - 1;i >= 0; i--){
            for(int buy = 0; buy <= 1;buy++){
                for(int cap = 1;cap <= k;cap++){
                    if(buy == 0)
                        dp[i][buy][cap] = Math.max(dp[i+1][0][cap],dp[i+1][1][cap] - prices[i]);
                    else
                        dp[i][buy][cap] = Math.max(dp[i+1][1][cap],dp[i+1][0][cap - 1] + prices[i]);
                }
            }
        }
        return dp[0][0][k];
    }
}

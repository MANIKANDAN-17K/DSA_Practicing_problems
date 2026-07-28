class Solution {
    int profit(int i,int k,int buy,int[] prices,int[][][] dp){
        if(k<= 0 || i >= prices.length){
            return 0;
        }
        if(dp[i][buy][k] != -1) return dp[i][buy][k];
        int res = 0;
        if(buy == 1){
            res = Math.max(-prices[i] + profit(i+1,k,0,prices,dp),profit(i+1,k,1,prices,dp));
        }else{
            res = Math.max(profit(i+1,k - 1,1,prices,dp)+ prices[i],profit(i+1,k,0,prices,dp));
        }
        return dp[i][buy][k] = res;
    }
    int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] d : dp){
            for(int[] d1 : d){
                Arrays.fill(d1,-1);
            }
        }
        return profit(0,k,1,prices,dp);
    }
}

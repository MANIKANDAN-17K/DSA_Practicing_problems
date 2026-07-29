class Solution {
    private int fcm(int n,int sum,int[][] dp,int[] coins){
        if(sum == 0) return 0;
        if(n == 0) return Integer.MAX_VALUE;
        if(dp[n-1][sum] != -1) return dp[n-1][sum];
        int take = Integer.MAX_VALUE;
        if(coins[n - 1] <= sum ){
            take = fcm(n,sum - coins[n-1],dp,coins);
            if(take != Integer.MAX_VALUE) take++;
        }
        int notTake = fcm(n-1,sum,dp,coins);
        return dp[n-1][sum] = Math.min(take,notTake);
        
    }
    public int minCoins(int coins[], int sum) {
        if(sum == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n][sum+1];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        int ans = fcm(n,sum,dp,coins);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}

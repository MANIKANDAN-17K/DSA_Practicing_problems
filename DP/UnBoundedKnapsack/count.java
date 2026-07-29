class Solution {
    private int findCount(int n,int sum,int[][] dp,int[] coins){
        if(sum == 0) return 1;
        if(sum<0 || n == 0) return 0;
        if(dp[n-1][sum] != -1) return dp[n-1][sum];
        return dp[n-1][sum] = findCount(n,sum - coins[n-1],dp,coins) + findCount(n-1,sum,dp,coins);
    }
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[][] dp = new int[n][sum+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return findCount(n,sum,dp,coins);
    }
}

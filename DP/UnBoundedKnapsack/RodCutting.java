class Solution {
    private int cal(int i,int j,int[] price,int[][] dp){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(i <= j){
            take = price[i - 1] + cal(i,j-i,price,dp);
        }
        int notTake = cal(i-1,j,price,dp);
        return dp[i][j] = Math.max(take,notTake);
    }
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return cal(n,n,price,dp);
    }
}

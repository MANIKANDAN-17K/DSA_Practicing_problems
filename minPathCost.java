class Solution {
    private int minPath(int i,int j,int[][] cost,int[][] dp){
        if(i == 0 && j == 0) return cost[i][j];
        if(i < 0 || j < 0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = cost[i][j] + minPath(i-1,j,cost,dp);
        int left = cost[i][j] +minPath(i,j-1,cost,dp);
        int dia = cost[i][j] + minPath(i-1,j-1,cost,dp);
        return dp[i][j] = Math.min(up,Math.min(left,dia));
    }
    public int minCost(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return minPath(n-1,m-1,cost,dp);
    }
}

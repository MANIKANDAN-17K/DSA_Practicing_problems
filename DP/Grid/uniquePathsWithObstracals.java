class Solution {
    private int countPath(int i,int j,int[][] grid,int[][] dp){
        if( i < 0 || j < 0) return 0;
        if(grid[i][j] == 1){
            return 0;
        }
        if( i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = countPath(i-1,j,grid,dp) + countPath(i,j-1,grid,dp);
    }
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return countPath(grid.length-1,grid[0].length-1,grid,dp);
    }
};

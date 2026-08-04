class Solution {
    private int maxPoint(int[][] mat,int i,int[][] dp,int prev){
        if(i >= mat.length) return 0;
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        int max = 0;
        for(int j = 0;j<=2;j++){
            if(prev != j)
                max = Math.max(max,mat[i][j] + maxPoint(mat,i+1,dp,j));
        }
        if(prev != -1) dp[i][prev] = max;
        return max;
        
    }

    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][3];
        for(int[] m : dp){
            Arrays.fill(m,-1);
        }
        return maxPoint(mat,0,dp,-1);
    }
}

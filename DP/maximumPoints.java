class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n+1][3];
        for(int i = n - 1;i >= 0;i--){
            for(int j = 0;j<3;j++){
                for(int k = 0;k<3;k++){
                    if(k == j) continue;
                    dp[i][j] = Math.max(dp[i][j],dp[i + 1][k]);
                }
                dp[i][j] += mat[i][j];
            }
        }
        return Math.max(dp[0][2],Math.max(dp[0][0],dp[0][1]));
    }
}

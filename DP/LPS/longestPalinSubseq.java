class Solution {
    private int finder(String s,int low,int high,int[][] dp){
        if(low > high) return 0;
        if(low == high) return 1;
        if(dp[low][high] != -1) return dp[low][high];
        if(s.charAt(low) == s.charAt(high)){
            return dp[low][high] = finder(s,low+1,high-1,dp) + 2;
        }
        return dp[low][high] = Math.max(finder(s,low + 1,high,dp),finder(s,low,high-1,dp));
    }
    public int longestPalinSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return finder(s,0,s.length() - 1,dp);
    }
}

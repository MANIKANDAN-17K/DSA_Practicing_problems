class Solution {
    static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] dp = new int[n+1];
        for(int i = 1;i<=m;++i){
            int prev = dp[0];
            for(int j = 1;j<=n;++j){
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[j] = 1+prev;
                else dp[j] = Math.max(dp[j],dp[j-1]);
                prev = temp;
            }
        }
        return dp[n];
    }
}

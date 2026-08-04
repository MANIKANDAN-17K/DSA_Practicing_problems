class Solution {
    static boolean isSubset(int[] arr,int sum,int n,int[][] dp){
        if(sum == 0) return true;
        if(n == 0) return false;
        if(dp[n][sum] != -1) return dp[n][sum] == 1;
        if(sum >= arr[n - 1]){
            dp[n][sum] = isSubset(arr,sum - arr[n-1],n-1,dp) || isSubset(arr,sum,n-1,dp) ? 1 : 0;
        }else{
            dp[n][sum] = isSubset(arr,sum,n-1,dp) ? 1 : 0;
        }
        return dp[n][sum] == 1;
    }
    static boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[arr.length+1][sum+1];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return isSubset(arr,sum,arr.length ,dp);
    }
}

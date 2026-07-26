class Solution {
    static boolean isExist(int[][] memo,int[] arr,int n,int sum){
        if(sum == 0) return true;
        if(n <= 0) return false;
        if(memo[n][sum] != -1) return memo[n][sum] == 1;
        if(arr[n - 1] > sum){
            memo[n][sum] = isExist(memo,arr,n-1,sum) ? 1 : 0;
        }else{
            memo[n][sum] = isExist(memo,arr,n-1,sum) || isExist(memo,arr,n-1,sum - arr[n-1]) ? 1 : 0;
        }
        return memo[n][sum] == 1;
    }
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int [][] memo = new int[n+1][sum + 1];
        for(int[] m : memo){
            Arrays.fill(m,-1);
        }
        return isExist(memo,arr,n,sum);
    }
}

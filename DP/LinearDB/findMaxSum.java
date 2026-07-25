class Solution {
    private int find(int[] arr,int n,int[] memo){
        if(n<= 0) return 0;
        if(n == 1) return arr[0];
        if(memo[n] != -1) return memo[n];
        int pick = arr[n - 1] + find(arr,n-2,memo);
        int notpick = find(arr,n-1,memo);
        memo[n] = Math.max(pick,notpick);
        return memo[n];
    }
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return find(arr,n,memo);
    }
}

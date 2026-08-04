class Solution {
    private int findMax(int[] memo,int n,int[] arr){
        if(n<=0) return 0;
        if(n==1) return arr[0];
        if(memo[n] != -1) return memo[n];
        memo[n] = Math.max(arr[n-1] + findMax(memo,n-2,arr),findMax(memo,n-1,arr));
        return memo[n];
    }
    public int findMaxSum(int arr[]) {
        int n  = arr.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return findMax(memo,n,arr);
    }
}

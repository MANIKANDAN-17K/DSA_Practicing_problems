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
/*
Input: arr[] = [6, 7, 1, 3, 8, 2, 4]
Output: 19
Explanation: The thief will steal from house 1, 3, 5 and 7, total money = 6 + 1 + 8 + 4 = 19.

Input: arr[] = [5, 3, 4, 11, 2]
Output: 16
Explanation: Thief will steal from house 1 and 4, total money = 5 + 11 = 16.

static int findMaxSumRec(int[] arr, int n) {
        
        // If no houses are left, return 0.
        if (n <= 0)  return 0;
      
        // If only 1 house is left, rob it. 
        if (n == 1)  return arr[0];

        // Two Choices: Rob the nth house and do not rob the nth house 
        int pick = arr[n - 1] + findMaxSumRec(arr, n - 2);
        int notPick = findMaxSumRec(arr, n - 1);

        // Return the max of two choices
        return Math.max(pick, notPick);
    }

    // Function to calculate the maximum stolen value
    static int findMaxSum(int[] arr) {
        int n = arr.length;
        
        // Call the recursive function for n houses
        return findMaxSumRec(arr, n);
    }

*/

class Solution {
    private int cal(int i,int j,int[] price,int[][] dp){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(i <= j){
            take = price[i - 1] + cal(i,j-i,price,dp);
        }
        int notTake = cal(i-1,j,price,dp);
        return dp[i][j] = Math.max(take,notTake);
    }
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return cal(n,n,price,dp);
    }
}
/*
Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index). Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: The value of n is equal to the size of price array.

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.

Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.

Input: price[] = [3]
Output: 3
Explanation: There is only 1 way to pick a piece of length 1.

class GFG {

    static int cutRodRecur(int i, int[] price) {
        if (i == 0) return ;
        int ans = 0;
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j] + cutRodRecur(i - j, price));
        }

        return ans;
    }

    static int cutRod(int[] price) {
        int n = price.length-1;

        return cutRodRecur(n, price);
    }
*/

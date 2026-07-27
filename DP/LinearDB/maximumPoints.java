class Solution {
    private int calculateMaxPt(int[][] mat,int[][] memo,int prev,int idx){
        int n = mat.length;
        if(idx >= n) return 0;
        if(prev != -1 && memo[idx][prev] != -1){
            return memo[idx][prev];
        }
        int maxi = 0;
        for(int i = 0;i<3;i++){
            if(prev != i){
                maxi = Math.max(maxi,mat[idx][i] + calculateMaxPt(mat,memo,i,idx + 1));
            }
        }
        if(prev != -1) memo[idx][prev] = maxi;
        return maxi;
    }
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] memo = new int[n][3];
        for(int[] m : memo){
            Arrays.fill(m,-1);
        }
        return calculateMaxPt(mat,memo,-1,0);
        
    }
}
/*
Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Given a 2D matrix mat[][], where mat[i][0], mat[i][1], and mat[i][2] represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum total merit points Geek can achieve .

Example:

Input: mat[][]= [[1, 2, 5],
               [3, 1, 1], 
               [3, 3, 3]]
Output: 11
Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.

Input: mat[][]= [[1, 1, 1],
               [2, 2, 2],
               [3, 3, 3]]
Output: 6
Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his total merit points as 6.

Input: mat[][]= [[4, 2, 6]]
Output: 6
Explanation: Geek will learn a new move to make his merit points as 6.

     static int calculateMaximumPoints(int i, int prev,
                                      int[][] mat) {

        int n = mat.length;

        // Base case: if we have processed all rows, return
        // 0
        if (i >= n)
            return 0;

        // Variable to store the maximum points for this row
        int maxi = 0;

        // Iterate over the 3 possible actions (columns)
        for (int j = 0; j < 3; j++) {

            // Ensure the current action is not the
            // same as the previous one
            if (j != prev)
                maxi = Math.max(maxi,mat[i][j] + 
                              calculateMaximumPoints(i + 1, j, mat));
        }
        return maxi;
    }

    // Wrapper function to start the recursive process
    static int maximumPoints(int[][] mat) {

        return calculateMaximumPoints(0, -1, mat);
    }

*/
    

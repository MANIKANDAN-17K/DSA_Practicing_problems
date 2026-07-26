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

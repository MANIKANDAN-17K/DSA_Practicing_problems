class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int i = 0;
        int j = n - 1;
        while(i < j){
            if(mat[j][i] == 1){
                j--;
            }else{
                i++;
            }
        }
        for(j = 0;j<n;j++){
            if(i == j) continue;
            if(mat[i][j] != 0 || mat[j][i] == 0) return -1;
        }
        return i;
    }
}

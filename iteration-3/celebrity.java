class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int top = 0;
        int down = n - 1;
        while(top < down){
            if(mat[top][down] == 1){
                top++;
            }else if(mat[down][top] == 1){
                down--;
            }else{
                top++;
                down--;
            }
        }
        for(int i = 0;i<n;i++){
            if(i == top) continue;
            if(mat[top][i] == 1 || mat[i][top] == 0){
                return -1;
            }
        }
        return top;
    }
}

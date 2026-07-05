class Solution {
    private boolean sS(int[][] mat,int r,int c){
        if(r == 9) return true;
        if(c == 9){
            return sS(mat,r+1,0);
        }
        if(mat[r][c] != 0){
           return  sS(mat,r,c+1);
        }
        
        for(int k = 1;k<=9;k++){
            if(isValid(k,r,c,mat)){
                mat[r][c] = k;
                if(sS(mat,r,c+1)) return true;
                mat[r][c] = 0;
            }
        }
        return false;
    }
    public void solveSudoku(int[][] mat) { sS(mat,0,0);   }
    private boolean isValid(int v,int r,int c,int[][] mat){
        for(int i= 0;i<9;i++){
            if(mat[i][c] == v) return false;
        }
        for(int i = 0;i<9;i++){
            if(mat[r][i] == v) return false;
        }
        int xbox = 3 * (r / 3);
        int ybox = 3 * (c / 3);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(mat[xbox+i][ybox+j] == v) return false;
            }
        }
        return  true;
    }
}

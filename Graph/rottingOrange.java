class Solution {
    private boolean isSafe(int x,int y,int n,int m){
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int cnt = 0;
        int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                int a = curr[0];
                int b = curr[1];
                for(int[] d : dir){
                    int x = a + d[0];
                    int y = b + d[1];
                    if(isSafe(x,y,n,m) && mat[x][y] == 1){
                        q.add(new int[]{x,y});
                        mat[x][y] = 2;
                        flag = true;
                    }
                }
            }
            if(flag) cnt++;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1){
                    return -1;
                }
            }
        }
        return cnt;
    }
}

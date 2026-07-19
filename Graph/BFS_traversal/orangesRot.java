class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int tot = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] != 0) tot++;
                if(mat[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
        int day = 0;
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count += size;
            for(int i = 0;i<size;i++){
                int[] pos = q.poll();
                for(int[] d : dir){
                    int nx = pos[0] + d[0];
                    int ny = pos[1] + d[1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny <m && mat[nx][ny] == 1){
                        mat[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            if(!q.isEmpty()) day++;
        }
        return tot == count ? day : -1;
    }
}

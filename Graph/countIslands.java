class Solution {
    private void dfs(char[][] grid,int ii,int j,boolean[][] visited){
        visited[ii][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {1,0,-1,1,-1,1,-1,0};
        for(int i = 0;i<8;i++){
            int nx = ii + dx[i];
            int ny = j + dy[i];
            if(nx >=0 && nx < n && ny < m && ny >= 0 && grid[nx][ny] == 'L' && !visited[nx][ny]){
                dfs(grid,nx,ny,visited);
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int isLands = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    isLands++;
                }
            }
        }
        return isLands;
    }
}

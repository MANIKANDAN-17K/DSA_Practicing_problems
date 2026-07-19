class Solution {
    private void dfs(int i,int j,char[][] grid,boolean[][] visited){
        visited[i][j] = true;
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 'L'){
                dfs(nx,ny,grid,visited);
            }
        }
        
    }

    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 'L'){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}

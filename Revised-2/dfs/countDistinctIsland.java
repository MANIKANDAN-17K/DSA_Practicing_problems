class Solution {
    private void dfs(int i,int j,int x,int y,ArrayList<String> shape,char[][] grid){
        grid[x][y]='#';
        shape.add((x-i)+","+(y-j));
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d : dir){
            int nx = d[0]+x;
            int ny = d[1]+y;
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 'L')
                dfs(i,j,nx,ny,shape,grid);
        }
    }
    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<ArrayList<String>> shapes = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 'L'){
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i,j,i,j,shape,grid);
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }
}

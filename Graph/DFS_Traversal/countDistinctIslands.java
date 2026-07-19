class Solution {
    private void dfs(int i,int j,int x,int y,char[][] grid,ArrayList<String> shape){
        if(i < 0 || j < 0||j >= grid[0].length||i >= grid.length||grid[i][j] != 'L'){
            return;
        }
        grid[i][j] = '#';
        shape.add((i - x)+","+(j - y));
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] d : dir){
            dfs(i+d[0],j+d[1],x,y,grid,shape);
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
                    dfs(i,j,i,j,grid,shape);
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }
}

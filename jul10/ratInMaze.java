class Solution {
    private boolean isSafe(int x,int y,int n,int[][] visit,int[][] maze){
        return(x >= 0 && y >= 0 &&
        x < n && y < n && visit[x][y] == 0 && maze[x][y] == 1);
    }
    private void solve(int x,int y,int n,int[][] visit,
    String path,ArrayList<String> res,int[][] maze){
        if(x == n -1 && y==n-1){
            res.add(path);
            return;
        }
        visit[x][y] = 1;
        if(isSafe(x+1,y,n,visit,maze)){
            solve(x+1,y,n,visit,path+"D",res,maze);
        }
        if(isSafe(x,y-1,n,visit,maze)){
            solve(x,y-1,n,visit,path+"L",res,maze);
        }
        if(isSafe(x,y+1,n,visit,maze)){
            solve(x,y+1,n,visit,path+"R",res,maze);
        }
        if(isSafe(x-1,y,n,visit,maze)){
            solve(x-1,y,n,visit,path+"U",res,maze);
        }
        visit[x][y] = 0;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        int[][] visit = new int[n][n];
        if(maze[0][0] == 1)
            solve(0,0,n,visit,"",res,maze);
        return res;
    }
}

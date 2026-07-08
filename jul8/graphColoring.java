class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] color = new int[v];
        return  solve(0,color,adj,m,v);
    }
    private boolean solve(int node,int[] color,ArrayList<ArrayList<Integer>> adj,int m,int v){
        if(v == node) return true;
        for(int i = 1;i<=m;i++){
            if(issafe(node,color,adj,i)){
                color[node] =  i;
                if(solve(node+1,color,adj,m,v)) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    private boolean issafe(int node,int[] color,ArrayList<ArrayList<Integer>> adj,int col){
        for(int nrb : adj.get(node)){
            if(color[nrb] == col) return false;
        }
        return true;
    }
}

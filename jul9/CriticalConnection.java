class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridge = new ArrayList<>();
        for(int i = 0;i<n;i++){
            bridge.add(new ArrayList<>());
        }
        for(List<Integer> node : connections){
            int u = node.get(0);
            int v = node.get(1);
            bridge.get(u).add(v);
            bridge.get(v).add(u);
        }
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis  = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        dfs(0,-1,tin,low,res,bridge,vis);
        return res;
    }
    private int timer = 1;
    private void dfs(int node,int parent,int[] tin,int[] low,
    List<List<Integer>> bridge,List<List<Integer>> conn,boolean[] vis){
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for(int nbr : conn.get(node)){
            if(nbr == parent) continue;
            if(!vis[nbr]){
                dfs(nbr,node,tin,low,bridge,conn,vis);
                low[node] = Math.min(low[node],low[nbr]);
                if(low[nbr] > tin[node]){
                    bridge.add(Arrays.asList(nbr,node));
                }
            }else{
                low[node] = Math.min(low[node],low[nbr]);
            }
        }

    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dis = new int[V];
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
            dis[i] = Integer.MAX_VALUE;
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dis[src] = 0;
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int[] edge = q.poll();
            int node = edge[0];
            int cost = edge[1];
            for(int[] nbr : adj.get(node)){
                int nn = nbr[0];
                int wt = nbr[1];
                if(cost + wt < dis[nn]){
                    dis[nn] = cost+wt;
                    q.add(new int[]{nn,dis[nn]});
                }
            }
        }
        return dis;
    }
}

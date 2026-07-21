class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        PriorityQueue<int[]> q =new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int node = temp[0];
            int cost = temp[1];
            if(cost > dis[node]) continue;
            for(int[] nbr : adj.get(node)){
                if(cost + nbr[1] < dis[nbr[0]]){
                    dis[nbr[0]] = cost + nbr[1];
                    q.add(new int[]{nbr[0],dis[nbr[0]]});
                }
            }
        }
        return dis;
    }
}

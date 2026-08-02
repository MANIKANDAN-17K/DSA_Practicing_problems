class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
       int[] dist  = new int[V];
       Arrays.fill(dist,(int)1e8);
       dist[src] = 0;
       for(int i = 0;i<V;i++){
           for(int[] edge : edges){
               int cn = edge[0];
               int nn = edge[1];
               int ww = edge[2];
               if(dist[cn] != 1e8 && dist[cn] + ww < dist[nn]){
                   if(i == V -1) return new int[]{-1};
                   dist[nn] = dist[cn] + ww;
               }
           }
       }
       return dist;
    }
}

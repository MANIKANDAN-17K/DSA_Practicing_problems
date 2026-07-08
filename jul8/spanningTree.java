class Pair{
    int dist;
    int node;
    Pair(int d,int n){
        dist = d;
        node = n;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] vis = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int wt = p.dist;
            int node = p.node;
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            for(int i = 0;i<adj.get(node).size();i++){
                int[] neighbour = adj.get(node).get(i);
                int edg = neighbour[1];
                int nextNode = neighbour[0];
                if(vis[nextNode] == 0){
                    pq.add(new Pair(edg,nextNode));
                }
            }
        }
        return sum;
    }
}

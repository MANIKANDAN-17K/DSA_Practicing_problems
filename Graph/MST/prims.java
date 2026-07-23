class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        PriorityQueue<int[]> q =new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{0,0});
        int[] visited = new int[V];
        int sum = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int node = temp[0];
            int wt = temp[1];
            if(visited[node] == 1) continue;
            visited[node] = 1;
            sum += wt;
            for(int[] nbr : adj.get(node)){
                int nn = nbr[0];
                int w = nbr[1];
                if(visited[nn] == 0) q.add(new int[]{nn,w});
            }
        }
        return sum;
    }
}

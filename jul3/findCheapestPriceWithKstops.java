class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,src,0});
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int stop = curr[0];
            int node = curr[1];
            int cost = curr[2];
            if(stop > k) continue;
            for(int[] adjList : adj.get(node)){
                int nextNode = adjList[0];
                int weight = adjList[1];
                if(cost + weight < dis[nextNode] && stop <= k){
                    dis[nextNode] = cost + weight;
                    q.offer(new int[] {stop+1,nextNode,cost+weight});
                }

            }
        }
        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}

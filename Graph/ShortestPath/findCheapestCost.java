class Solution {

    public static int findCheapestCost(int n, int[][] edges, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        q.add(new int[]{0,src,0});
        while(!q.isEmpty()){
            int[] node = q.poll();
            int step = node[0];
            int next = node[1];
           int cost = node[2];
            
            if(step > k) continue;
            for(int[] nbr : adj.get(next)){
                int nn = nbr[0];
                int wt = nbr[1];
                if(step <= k && cost + wt < dis[nn]){
                    dis[nn] = cost + wt;
                    q.add(new int[]{step + 1,nn,dis[nn]});
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            order.add(node);
            for(int nbr : adj.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0)
                    q.offer(nbr);
            }
        }
        if(n == order.size())
            return order;
        return new ArrayList<>();
    }
}

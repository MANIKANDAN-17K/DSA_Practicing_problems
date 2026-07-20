class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[] depth = new int[n];
        for(int[] pre : prerequisites){
            int des = pre[0];
            int src = pre[1];
            graph.get(src).add(des);
            depth[des]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(depth[i] == 0) q.add(i);
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            order.add(node);
            for(int nbr : graph.get(node)){
                depth[nbr]--;
                if(depth[nbr] == 0) q.add(nbr);
            }
        }
        return order.size() == n ? order : new ArrayList<>();
    }
}

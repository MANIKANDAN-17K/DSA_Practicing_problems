class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] pre : p){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0) q.add(i);
        }
        ArrayList<Integer> res =  new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        return res.size() == n ? res : new ArrayList<>();
    }
}

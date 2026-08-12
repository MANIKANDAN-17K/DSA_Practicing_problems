class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] p : pre){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i< n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(indegree[i] != 0) return new ArrayList<>();
        }
        return res;
    }
}

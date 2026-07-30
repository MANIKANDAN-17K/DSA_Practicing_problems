class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] dep = new int[n];
        for(int i= 0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int[] r : p){
            int a = r[0];
            int b = r[1];
            res.get(b).add(a);
            dep[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(dep[i] == 0)
                q.add(i);
        }
        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            ans.add(node);
            for(int adjNode : res.get(node)){
                dep[adjNode]--;
                if(dep[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        return cnt == n ? ans : new ArrayList<>();
    }
}

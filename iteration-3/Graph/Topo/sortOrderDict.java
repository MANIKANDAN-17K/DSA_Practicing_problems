class Solution {
    private ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[26];
        for(int i = 0;i<26;i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<26;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
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
        if(res.size() != 26) return new ArrayList<>();
        return res;
    }
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int k = 26;
        for(int i = 0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<words.length;i++){
            for(char ch : words[i].toCharArray()){
                 set.add(ch - 'a');
            }
        }
        for(int i = 1;i<words.length;i++){
            String str1 = words[i-1];
            String str2 = words[i];
            int len = Math.min(str1.length(),str2.length());
            int j = 0;
            while(j < len && str1.charAt(j) == str2.charAt(j)) j++;
            if(j == len){
                if(str1.length() > str2.length()) return "";
                continue;
            }
           
            adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
        }
        ArrayList<Integer> topo = topoSort(adj);
        if(topo.isEmpty()) return "";
        StringBuilder ans = new StringBuilder();
        for(int node : topo){
            if(set.contains(node)){
                ans.append((char)(node + 'a'));
            }
        }
        return ans.toString();
    }
}

class Solution {
    private ArrayList<Integer> topologicalSort(int k,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[k];
        for(int i = 0;i<k;i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<k;i++){
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
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }
        if(res.size() != k) return new ArrayList<>();
        return res;
    }
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int k =26;
        for(int i = 0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        Set<Integer> unique = new HashSet<>();
        for(String word : words){
            for(char ch : word.toCharArray()){
                unique.add(ch - 'a');
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
        ArrayList<Integer> topo = topologicalSort(26,adj);
        if(topo.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for(int nbr : topo){
            if(unique.contains(nbr)){
                res.append((char)(nbr + 'a'));
            }
        }
        return res.toString();
    }
}

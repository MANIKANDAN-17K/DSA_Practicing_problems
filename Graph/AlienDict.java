class Solution {
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] exist =new boolean[26];
        Queue<Integer> q =new LinkedList<>();
        for(String s : words){
            for(char ch : s.toCharArray()){
                exist[ch - 'a'] = true;
            }
        }
        for(int i = 0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i + 1 <words.length;++i){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            int j = 0;
            while(j < len && s1.charAt(j) == s2.charAt(j)) ++j;
            if(j < len){
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';
                adj.get(u).add(v);
                inDegree[v]++;
            }
            else if(s1.length()>s2.length()) return "";
        }
        for(int i =0;i<26;i++){
            if(exist[i] && inDegree[i] == 0){
                q.offer(i);
            }
        }
        String res = "";
        while(!q.isEmpty()){
            int u = q.poll();
            res += (char)(u + 'a');
            for(int v : adj.get(u)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    q.offer(v);
                }
            }
        }
        for(int i = 0;i<26;i++){
            if(exist[i] && inDegree[i] != 0) return "";
        }
        return  res;
    }
}

class DisJointSet{
    int[] parent;
    int[] size;
    DisJointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUPair(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findUPair(parent[node]);
        return parent[node];
    }

    public void unionBySize(int u,int v){
        int ul = findUPair(u);
        int vl = findUPair(v);
        if(ul == vl) return;
        if(size[ul] < size[vl]){
            parent[vl] = ul;
            size[ul] += size[vl];
        }else{
            parent[ul] = vl;
            size[vl] += size[ul];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> mailMap = new HashMap<>();
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        for(int i = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mailMap.containsKey(mail)){
                    mailMap.put(mail,i);
                }else{
                    ds.unionBySize(i,mailMap.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedList = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mergedList[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it : mailMap.entrySet()){
            String mail = it.getKey();
            int node = ds.findUPair(it.getValue());
            mergedList[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0;i<n;i++){
            if(mergedList[i].isEmpty()) continue;
            Collections.sort(mergedList[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail : mergedList[i]){
                temp.add(mail);
            }
            ans.add(temp);
        }
        ans.sort((a,b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}

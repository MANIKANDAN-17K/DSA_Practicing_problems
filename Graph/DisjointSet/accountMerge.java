class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUParent(int node){
        if(node == parent[node]) return node;
        parent[node] = findUParent(parent[node]);
        return parent[node];
    }
    public void findByUnion(int u,int v){
        int up = findUParent(u);
        int vp = findUParent(v);
        if(parent[up] == parent[vp]) return;
        if(parent[up] < parent[vp]){
            parent[up] = vp;
            size[vp] += size[up];
        }else{
            parent[vp] = up;
            size[up] += size[vp];
        }
    }
}
class Solution {
    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        int n = arr.length;
        DSU ds = new DSU(n);
        HashMap<String,Integer> mailMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 1;j<arr[i].length;j++){
                if(!mailMap.containsKey(arr[i][j])){
                    mailMap.put(arr[i][j],i);
                }else{
                    ds.findByUnion(i,mailMap.get(arr[i][j]));
                }
            }
        }
        ArrayList<String>[] merge = new ArrayList[n];
        for(int i = 0 ;i<n;i++){
            merge[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> mail : mailMap.entrySet()){
            String key = mail.getKey();
            int node = ds.findUParent(mail.getValue());
            merge[node].add(key);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(merge[i].isEmpty()) continue;
            Collections.sort(merge[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            for(String str : merge[i]){
                temp.add(str);
            }
            ans.add(temp);
        }
        ans.sort((a,b) -> a.get(0).compareTo(b.get(0)));
        return ans;
    }
}

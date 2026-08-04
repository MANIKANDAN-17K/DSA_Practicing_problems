class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findUParent(int n){
        if(n == parent[n]){
            return n;
        }
        parent[n] = findUParent(parent[n]);
        return parent[n];
    }
    public void findByUnion(int u,int v){
        int up= findUParent(u);
        int vp = findUParent(v);
        if(parent[up] == parent[vp]) return;
        if(parent[up] < parent[vp]){
            parent[up] = vp;
            size[vp] += size[up];
        }else{
            parent[vp] = up;
            size[vp] += size[vp];
        }
    }
}
class Solution {
    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        int n = arr.length;
        DSU dsu = new DSU(n);
        HashMap<String,Integer> mpp = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 1;j< arr[i].length;j++){
                String str = arr[i][j];
                if(!mpp.containsKey(str)){
                    mpp.put(str,i);
                }else{
                    dsu.findByUnion(i,mpp.get(str));
                }
            }
        }
        ArrayList<String>[] mergeList = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mergeList[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> key : mpp.entrySet()){
            int node = dsu.findUParent(key.getValue());
            String str = key.getKey();
            mergeList[node].add(str);
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(mergeList[i].isEmpty()) continue;
            Collections.sort(mergeList[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            for(String str : mergeList[i]){
                temp.add(str);
            }
            res.add(temp);
        }
        res.sort((a,b) -> a.get(0).compareTo(b.get(0)));
        return res;
    }
}

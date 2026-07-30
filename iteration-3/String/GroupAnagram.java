class Solution {
    private String hashKey(String str){
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0;i<26;i++){
            sb.append(freq[i]);
            sb.append("$");
        }
        return sb.toString();
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            String key = hashKey(arr[i]);
            if(!mp.containsKey(key)){
                mp.put(key,res.size());
                res.add(new ArrayList<>());
                
            }
            res.get(mp.get(key)).add(arr[i]);
        }
        return res;
    }
}

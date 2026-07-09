class Solution {
    private String getHash(String str){
        int[] freq = new int[26];
        StringBuilder res = new StringBuilder();
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0;i<26;++i){
            res.append(freq[i]);
            res.append("$");
        }
        return res.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> res = new ArrayList<>();
        Map<String,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;++i){
            String key = getHash(strs[i]);
            if(!mp.containsKey(key)){
                mp.put(key,res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(key)).add(strs[i]);
        }
        return res;
    }
}

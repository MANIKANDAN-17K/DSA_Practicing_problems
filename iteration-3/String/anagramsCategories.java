class Solution {
    private String hash(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i = 0;i< 26;i++){
            key.append(freq[i]);
            key.append("$");
        }
        return key.toString();
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String,Integer> mp = new HashMap<>();
        for(String str : arr){
            String key = hash(str);
            if(!mp.containsKey(key)){
                mp.put(key,res.size());
                res.add(new ArrayList<>());
            }
            res.get(mp.get(key)).add(str);
        }
        return res;
    }
}

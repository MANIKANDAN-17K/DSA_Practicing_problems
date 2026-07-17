class Solution {
    public int longestSubstr(String s, int k) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int res = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int r = 0;r<s.length();r++){
            
            freq.put(s.charAt(r),freq.getOrDefault(s.charAt(r),0)+1);
            max = Math.max(max,freq.get(s.charAt(r)));
            if(r - l + 1 - max > k){
                freq.put(s.charAt(l),freq.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }
}

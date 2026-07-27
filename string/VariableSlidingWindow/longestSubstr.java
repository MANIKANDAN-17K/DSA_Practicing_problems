class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int maxlen = -1;
        int maxFreq = -1;
        int[] freq= new int[26];
        int j = 0;
        for(int i = 0;i<n;i++){
            freq[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(i) - 'A']);
            while((i - j + 1) - maxFreq > k){
                freq[s.charAt(j) - 'A']--;
                j++;
            }
            maxlen = Math.max(maxlen,(i - j + 1));
        }
        return maxlen;
    }
}

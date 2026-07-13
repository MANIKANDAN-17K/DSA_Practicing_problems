class Solution {
          public int 
  (String s, int k) {
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        int[] freq = new int[26];
        int left = 0;
        for(int right = 0;right < n;right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right) - 'A']);
            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
}

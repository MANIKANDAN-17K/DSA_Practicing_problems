class Solution {
    public int longestUniqueSubstr(String s) {
        boolean[] vis = new boolean[26];
        int l = 0;
        int r = 0;
        int max = 1;
        while(r < s.length()){
            while(vis[s.charAt(r) - 'a']){
                vis[s.charAt(l) - 'a'] = false;
                l++;
            }
            vis[s.charAt(r) - 'a'] = true;
            max = Math.max(max,(r-l+1));
            r++;
        }
       return max;
    }
}

/*
Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.

Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
*/

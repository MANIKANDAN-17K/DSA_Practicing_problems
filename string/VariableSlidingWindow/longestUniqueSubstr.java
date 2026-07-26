class Solution {
    public int longestUniqueSubstr(String s) {
        if(s.length() == 1) return 1;
        boolean[] vis = new boolean[26];
        int l = 0;
        int r = 0;
        int max = 0;
        while(r < s.length()){
            while(vis[s.charAt(r) - 'a'] == true) {
                vis[s.charAt(l) - 'a'] = false;
                l++;
            }
            vis[s.charAt(r) - 'a'] = true;
            max = Math.max(max,r - l + 1);
            r++;
        }
        return max;
    }
}

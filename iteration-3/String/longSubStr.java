class Solution {
    public int longestUniqueSubstr(String s) {
        boolean[] visit = new boolean[26];
        int  l = 0;
        int max = 0;
        int r = 0;
        while(r < s.length()){
            while(visit[s.charAt(r) - 'a']){
                visit[s.charAt(l) - 'a'] = false;
                l++;
            }
            visit[s.charAt(r) - 'a'] = true;
            max = Math.max(max,(r-l+1));
            r++;
        }
        return max;
    }
}

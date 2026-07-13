class Solution {
    int longestUniqueSubstring(String s) {
        int n = s.length();
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        int start = 0;
        int res = 0;
        for(int end = 0;end < n;end++){
            start = Math.max(start,arr[s.charAt(end) - 'a']+1);
            res = Math.max(res,end - start + 1);
            arr[s.charAt(end )- 'a'] = end;
        }
        return res;
    }
}

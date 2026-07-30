class Solution {
    public String longestCommonPrefix(String words[]) {
       StringBuilder res = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for(String str : words)
            minLen = Math.min(minLen,str.length());
        for(int i = 0;i<minLen;i++){
            char ch = words[0].charAt(i);
            for(String str : words){
                if(str.charAt(i) != ch) return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }
}

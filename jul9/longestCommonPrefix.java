class Solution {
    public String longestCommonPrefix(String arr[]) {
        int minL = arr[0].length();
        for(String str : arr){
            minL = Math.max(minL,str.length());
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<minL;i++){
            char ch = arr[0].charAt(i);
            for(String s : arr){
                if(s.charAt(i) != ch) return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }
}

class Solution {
    private boolean wordBreakRec(int i, String s,String[] dict){
        if(i == s.length()) return true;
        String prefix = "";
        for(int j = i;j<s.length();j++){
            prefix += s.charAt(j);
            if(Arrays.asList(dict).contains(prefix) && wordBreakRec(j+1,s,dict)){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, String[] dictionary) {
        return wordBreakRec(0,s,dictionary);
    }
}

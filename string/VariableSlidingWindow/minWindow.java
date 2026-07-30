class Solution {
    public static String minWindow(String s, String p) {
        HashMap<Character,Integer> tar = new HashMap<>();
        HashMap<Character,Integer> allF = new HashMap<>();
        for(char ch : p.toCharArray()){
            tar.put(ch,tar.getOrDefault(ch,0)+1);
        }
        int size =tar.size();
        int l = 0,r = 0,form = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            allF.put(ch,allF.getOrDefault(ch,0)+1);
            if(tar.containsKey(ch) && tar.get(ch).intValue() == allF.get(ch).intValue()){
                form++;
            }
            while(l <= r && form == size){
                if((r-l+1) < minLen){
                    minLen = r - l + 1;
                    minLeft = l;
                }
                char lc = s.charAt(l);
                allF.put(lc,allF.get(lc)-1);
                if(tar.containsKey(lc) && tar.get(lc) >  allF.get(lc)){
                    form--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft,minLeft+minLen);  
    }
}

class Solution {
    public static String minWindow(String s, String p) {
        HashMap<Character,Integer> pf = new HashMap<>();
        for(char ch : p.toCharArray()){
            pf.put(ch,pf.getOrDefault(ch,0)+1);
        }
        int req = pf.size();
        HashMap<Character,Integer> sf = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minLeft= 0;
        int r = 0,l = 0,form = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            sf.put(ch,sf.getOrDefault(ch,0)+1);
            if(pf.containsKey(ch) && pf.get(ch).intValue() == sf.get(ch).intValue()){
                form++;
            }
            while(l<=r && req == form){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    minLeft = l;
                }
                char c = s.charAt(l);
                sf.put(c,sf.get(c)-1);
                if(pf.containsKey(c) && sf.get(c) < pf.get(c)){
                    form--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft,minLeft+minLen);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] countP = new int[256];
        int[] countS = new int[256];
        for(int i = 0;i<len2;i++)
            countP[t.charAt(i)]++;
        int start = 0,start_idx = -1,min_len = Integer.MAX_VALUE;
        int count = 0;
        for(int j = 0;j<len1;j++){
            char startChar = s.charAt(j);
            countS[startChar]++;
            if(countS[startChar] > 0 && countS[startChar] <= countP[startChar]){
                count++;
            }
            if(count == len2){

                    while(countS[startChar = s.charAt(start)] > countP[startChar] || countP[startChar] == 0){
                        if(countS[startChar] > countP[startChar]){
                            countS[startChar]--;
                        }
                        start++;
                    }
                    int len = j - start + 1;
                    if(min_len > len){
                        min_len = len;
                        start_idx = start;
                    }
                }
            }
        if(start_idx == -1) return "";
        return s.substring(start_idx,start_idx+min_len);
    }
}

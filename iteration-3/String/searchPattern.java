class Solution {
    private int[] constructLPS(String pat){
        int n = pat.length();
        int len = 0;
        int i = 1;
        int[] lps = new int[n];
        lps[0] = 0;
        while(i < n){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len > 0) len = lps[len - 1];
                else{ lps[i] = 0; i++;}
            }
        }
        return lps;
    }
    ArrayList<Integer> search(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        int[] lps = constructLPS(pat);
        int i  = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < m){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == n){
                    res.add(i-j);
                    j = lps[j-1];
                }
            }else{
                if(j>0) j = lps[j-1];
                else i++;
            }
        }
        return res;
    }
}

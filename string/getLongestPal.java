class Manacher{
    int[] p;
    String ms;
    public Manacher(String s){
        StringBuilder sb = new StringBuilder("@");
        for(char ch : s.toCharArray()){
            sb.append('#').append(ch);
        }
        sb.append("#$");
        ms = sb.toString();
        runner();
    }
    private void runner(){
        int n = ms.length();
        int l = 0;
        int r = 0;
        p = new int[n];
        for(int i = 1;i<n-1;i++){
            int mirror = (r + l - i);
            if(mirror >= 0 && mirror < n){
                p[i] = Math.max(0,Math.min(r-i,p[mirror]));
            }else{
                p[i]= 0;
            }
            while((i - 1 - p[i]) >=0 && (i + 1+ p[i]) < n && ms.charAt(i - 1 - p[i]) == ms.charAt(i + 1 + p[i])){
                ++p[i];
            }
            if(i + p[i] > r){
                l = i - p[i];
                r = i + p[i];
            }
        }
    }
    public int getLength(int cen,int odd){
        return p[2 * cen + 2 + (odd == 0 ? 1 : 0)];
    }
}

class Solution {
    public String getLongestPal(String s) {
        Manacher m =  new Manacher(s);
        int l = 0,maxL = 1;
        int start = 0;
        for(int i = 0;i<s.length();++i){
            int ol = m.getLength(i,1);
            if(ol > maxL){
                start = i - (ol - 1) / 2;
            }
            int el = m.getLength(i,0);
            if(el > maxL){
                start = i - (el - 1) / 2;
            }
            maxL = Math.max(maxL,Math.max(ol,el));
        }
        return s.substring(start,start+maxL);
    }
}

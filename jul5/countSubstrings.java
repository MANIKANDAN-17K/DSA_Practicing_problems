class Solution {
    private int check(String s,int i,int j){
        int c = 0;
        int n = s.length();
        while(i>= 0 && j <n){
            if(s.charAt(i) == s.charAt(j)){
                c++;
                i--;
                j++;
            }else{
                break;
            }
        }
        return c;
    }
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            ans += check(s,i,i);
            ans += check(s,i,i+1);
        }
        return  ans;
    }
}

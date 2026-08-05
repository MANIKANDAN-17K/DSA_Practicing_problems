class Solution {
    public int countMinReversals(String s) {
        int o = 0;
        int c = 0;
        for(char ch : s.toCharArray()){
            if(ch == '{'){
                o++;
            }else{
                if(o > 0) o--;
                else c++;
            }
        }
        if((o + c) % 2 != 0) return -1;
        return (o + 1)/2 + (c +  1)/2;
    }
}

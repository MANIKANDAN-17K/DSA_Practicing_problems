class Pair <K,V>{
    private K key;
    private V val;
    Pair(K key,V val){
        this.key = key;
        this.val = val;
    }
    public K getKey(){
        return key;
    }
    public V getVal(){
        return val;
    }
}
class Solution {
    public int wordLadder(String[] words, String s, String e) {
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(s,1));
        HashSet<String> st = new HashSet<>();
        for(String word : words){
            st.add(word);
        }
        st.remove(s);
        while(!queue.isEmpty()){
            String word = queue.peek().getKey();
            int step = queue.peek().getVal();
            queue.poll();
            if(word.equals(e)) return step;
            for(int i = 0;i<word.length();i++){
                char[] chword = word.toCharArray();
                char ch = chword[i];
                for(char c = 'a';c<='z';c++){
                    chword[i] = c;
                    String str = new String(chword);
                    if(st.contains(str)){
                        st.remove(str);
                        queue.add(new Pair<>(str,step + 1));
                    }
                }
                chword[i] = ch;
            }
        }
        return 0;
    }
}

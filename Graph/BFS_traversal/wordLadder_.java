
class Pair<K,V>{
    K key;
    V value;
    Pair(K key,V value){
        this.key = key;
        this.value = value;
    }
    K getKey(){
        return key;
    }
    V getValue(){
        return value;
    }
}
class Solution {
    public int wordLadder(String[] words, String s, String e) {
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(s,1));
        Set<String> set = new HashSet<>(Arrays.asList(words));
        set.remove(s);
        while(!q.isEmpty()){
            String word = q.peek().getKey();
            if(word.equals(e)) return q.peek().getValue();
            for(int i = 0;i<word.length();i++){
                char[] arr =  word.toCharArray();
                char ch = arr[i];
                for(char c = 'a';c <= 'z';c++){
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        q.add(new Pair<>(newWord,q.peek().getValue()+1));
                        set.remove(newWord);
                    }
                }
                arr[i] = ch;
            }
            q.poll();
        }
        return 0;
    }
}

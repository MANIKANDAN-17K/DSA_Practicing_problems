/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Pair<K,V>{
    K node;
    V value;
    Pair(K node,V value){
        this.node = node;
        this.value = value;
    }
    public K getNode(){
        return node;
    }
    public V getValue(){
        return value;
    }
}


class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        if(root == null) return new ArrayList<>();
        Map<Integer,Integer> mpp = new TreeMap<>();
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair<Node,Integer> pair = q.poll();
            Node node = pair.getNode();
            int value = pair.getValue();
            mpp.put(value,node.data);
            if(node.left != null) q.add(new Pair(node.left,value-1));
            if(node.right != null) q.add(new Pair(node.right,value+1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}

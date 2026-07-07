/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        Node cur = root;
        while(cur != null){
            if(cur.left == null){
                preOrder.add(cur.data);
                cur = cur.right;
            }else{
                Node pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    preOrder.add(cur.data);
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    return preOrder;
    }
}

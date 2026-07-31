/*Structure of tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
};*/

class Solution {
    static int dia = 0;
    private int height(Node root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(r + l > dia){
            dia = r + l;
        }
        return 1 + Math.max(l,r);
    }
    public int diameter(Node root) {
        dia = 0;
        height(root);
        return dia;
    }
}

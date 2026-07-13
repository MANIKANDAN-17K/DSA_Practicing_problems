/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int maxDiameter;
    private int height(Node root){
        if(root == null) return 0;
        int h1 = height(root.left);
        int h2 = height(root.right);
        if(h1 + h2 > maxDiameter){
            maxDiameter = h1 + h2;
        }
        return 1 + Math.max(h1,h2);
    }
    public int diameter(Node root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }
}

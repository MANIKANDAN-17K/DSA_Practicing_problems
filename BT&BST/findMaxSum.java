/*
Definition for Node
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/
class Solution {
public int MaxVal = Integer.MIN_VALUE;
    int findMaxSum(Node root) {
        dfs(root);
        return MaxVal;
    }
    private int dfs(Node node){
        if(node == null) return 0;
        int l = Math.max(0,dfs(node.left));
        int r = Math.max(0,dfs(node.right));
        MaxVal = Math.max(MaxVal,l + r + node.data);
        return Math.max(l,r) + node.data;
    }
}

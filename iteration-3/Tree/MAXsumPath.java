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
    static int maxSum = Integer.MIN_VALUE;
    int dfs(Node root){
        if(root == null) return 0;
        int l = Math.max(0,dfs(root.left));
        int r = Math.max(0,dfs(root.right));
        maxSum = Math.max(maxSum,l+r+root.data);
        return Math.max(l,r)+root.data;
    }
    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    class BSTinfo{
        int minS;
        int maxS;
        int size;
        BSTinfo(int m,int M,int s){
            minS = m;
            maxS = M;
            size = s;
        }
    }
    private BSTinfo largerBST(TreeNode root){
        if(root == null) return new BSTinfo(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        BSTinfo left = largerBST(root.left);
        BSTinfo right = largerBST(root.right);
        if(left.maxS < root.val && right.minS > root.val){
            int sum = root.val + left.size + right.size;
            ans = Math.max(ans,sum);
            return new BSTinfo(Math.min(left.minS,root.val),Math.max(right.maxS,root.val),sum );
        }
        return new BSTinfo(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }
    public int maxSumBST(TreeNode root) {
        largerBST(root);
        return ans;
    }
}

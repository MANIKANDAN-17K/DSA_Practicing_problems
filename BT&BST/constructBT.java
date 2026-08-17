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
    private int findMiddle(int[] arr,int val){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] == val){
                return  i;
            }
        }
        return -1;
    }
    private TreeNode construct(int[] p,int[] in,int[] pre,int l,int r){
        if(l > r) return null;
        int node = p[pre[0]];
        pre[0]++;
        TreeNode root = new TreeNode(node);
        int mid = findMiddle(in,node);
        root.left = construct(p,in,pre,l,mid - 1);
        root.right = construct(p,in,pre,mid + 1,r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] pre = {0};
        return construct(preorder,inorder,pre,0,inorder.length - 1);
    }
}

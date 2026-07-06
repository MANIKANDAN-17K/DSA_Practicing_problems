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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0;i<preorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,inMap);
    }
    private TreeNode build(int[] preorder,int pS,int pE,
    int[] inorder,int iS,int iE,Map<Integer,Integer> inMap){
        if(pS > pE || iS > iE ) return null;
        TreeNode root = new TreeNode(preorder[pS]);
        int inRoot = inMap.get(root.val);
        int numLeft = inRoot - iS;
        root.left = build(preorder,pS + 1,pS + numLeft + 1,inorder,iS,inRoot - 1,inMap);
        root.right = build(preorder,pS+numLeft+1,pE,inorder,inRoot + 1,iE,inMap);
        return root;
    }
}

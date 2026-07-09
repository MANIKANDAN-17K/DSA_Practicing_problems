/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    private boolean dfs(Node root,HashSet<Integer> set,int target){
        if(root == null) return false;
        if(set.contains(target - root.data)) return true;
        set.add(root.data);
        return dfs(root.left,set,target) || dfs(root.right,set,target);
    }
    boolean findTarget(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root,set,target);
    }
}

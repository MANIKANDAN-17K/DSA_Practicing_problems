/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int maxLevelSum(Node root) {
        Queue<Node> q = new LinkedList<>();
        int max = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0;i<size;i++){
                Node temp = q.poll();
                sum += temp.data;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}

/* 
Input: root = [4, 2, -5, -1, 3, -2, 6]
Output: 6
Explanation: Sum of all nodes of 0th level is 4. 
Sum of all nodes of 1st level is 2 - 5 = -3. 
Sum of all nodes of 2nd level is -1 + 3 -2 + 6 = 6. 
Hence, maximum sum is 6.
*/

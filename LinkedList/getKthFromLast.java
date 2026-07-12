/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public int getKthFromLast(Node head, int k) {
        Node point1 = head;
        for(int i = 1;i<k;i++){
            point1 = point1.next;
            if(point1 == null) return -1;
        }
        Node point2 = head;
        while(point1.next != null){
            point2 = point2.next;
            point1= point1.next;
        }
        return point2.data;
    }
}

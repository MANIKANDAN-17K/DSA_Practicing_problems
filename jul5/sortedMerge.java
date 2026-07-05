/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                dummy.next = h1;
                h1 = h1.next;
               }else{
                dummy.next = h2;
                h2 = h2.next;
            }
            dummy = dummy.next;
        }
        if(h1 != null){
            dummy.next = h1;
        }else{
            dummy.next = h2;
        }
        return temp.next;
    }
}

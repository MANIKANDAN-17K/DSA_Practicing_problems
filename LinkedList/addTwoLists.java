/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    private Node revList(Node temp){
        
        Node prev = null;
        while(temp != null){
            Node curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }
    public Node addTwoLists(Node head1, Node head2) {
        int carry = 0;
         head1 = revList(head1);
         head2 = revList(head2);
         Node sum = null;
        while(head1 != null || head2!= null || carry > 0){
            int Val = carry;
            if(head1 != null){
                Val += head1.data;
                head1 = head1.next;
            }
            if(head2 != null){
                Val += head2.data;
                head2 = head2.next;
            }
            carry = Val / 10;
            Val %= 10;
            Node newNode = new Node(Val);
            newNode.next = sum;
            sum = newNode;
        }
        while(sum != null && sum.data == 0) sum = sum.next;
        return sum == null ? new Node(0) : sum;

    }
}

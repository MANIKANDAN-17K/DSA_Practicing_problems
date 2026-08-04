/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    private Node reverseList(Node node){
        Node prev = null;
        Node curr = node;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow  = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node head1 = slow;
        slow = head;
        head1 = reverseList(head1);
        while(head1 != null){
            if(slow.data != head1.data){
                return false;
            }
            slow = slow.next;
            head1 = head1.next;
        }
        return true;
    }
}

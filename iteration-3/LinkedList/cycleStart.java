/*
class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
};
*/

class Solution {
    public int cycleStart(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(slow != null && fast != null){
                    if(slow == fast){
                        return slow.data;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return -1;
        
    }
}

/*
You are given the head of a singly linked list. If a loop is present in the linked list then return the first node of the loop else return -1.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

  Input: pos = 2,
   
Output: 3
Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.
  */

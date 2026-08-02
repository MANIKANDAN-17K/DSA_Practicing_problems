/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}*/

class Solution {

    public Node flatten(Node root) {
    PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> Integer.compare(a.data,b.data));
    Node head = null;
    Node tail = null;
    while(root != null){
        q.add(root);
        root = root.next;
    }
    while(!q.isEmpty()){
        Node minNode = q.poll();
        if(head == null){
            head = minNode;
            tail = minNode;
        }else{
            tail.bottom = minNode;
            tail = tail.bottom;
        }
        if(minNode.bottom != null){
            q.offer(minNode.bottom);
            minNode.bottom  = null;
        }
    }
    return head;
    }
}

/*
In a linked list, every node has two pointers: next and bottom. The heads of n linked lists are connected using the next pointer, while the bottom pointer points to the next node in the current linked list.

Each linked list is sorted in non-decreasing order of data, and the head nodes are also sorted in non-decreasing order.

Given the head of the first linked list, flatten the linked lists into a single sorted linked list such that every node is connected using only the bottom pointers

Output: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 10 is pointing to 20 and so on.
So, after flattening the linked list the sorted list will be 
5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 40 -> 45.
  */

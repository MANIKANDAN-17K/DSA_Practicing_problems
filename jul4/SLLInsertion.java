 class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}

 class SLL{
    Node head;
    int size;
    SLL(){
        this.head = null;
        this.size = 0;
    }
    public void insertAtBeg(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void insertAtEnd(int val){
        if(head == null){
            insertAtBeg(val);
        }else{
            Node newNode = new Node(val);
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
            size++;
        }
    }
    public void insertAtPosition(int data,int pos){
        if(pos < 0 || pos > size){
            return;
        }
        if(pos == 0){
            insertAtBeg(data);
            return;
        }
        if(pos == size){
            insertAtEnd(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 0;i<pos - 1;i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
     public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
        System.out.println("Size: " + size);
    }
}

public class Main
{
	public static void main(String[] args) {
		SLL sll = new SLL();
		sll.insertAtBeg(10);
		sll.insertAtBeg(23);
		sll.display();
		sll.insertAtEnd(100);
		sll.insertAtEnd(200);
		sll.display();
		sll.insertAtPosition(1000,2);
		sll.insertAtPosition(2000,3);
		sll.display();
	}
}

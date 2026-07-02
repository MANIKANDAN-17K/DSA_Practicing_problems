public class Main
{
	public static void main(String[] args) {
	    Queue q = new Queue();
	    q.enqueue(10);
		System.out.println(q.dequeue());
	}
}
class Queue{
    int[] arr;
    int front = 0;
    int rear  = -1;
    int size = 0;
    public Queue(){
        arr  = new int[5];
    }
    public void enqueue(int n){
        if(size == 5){
            System.out.println("overflow");
        }
        rear++;
        arr[rear] = n;
        size++;
    }
    public int dequeue(){
        if(size == 0){
            System.out.println("underflow");
            return -1;
        }
        int n = arr[front];
        front++;
        size--;
        return n;
    }
}


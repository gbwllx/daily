package book.javaalg.part4;

public class Queue {//java.util.Queue 
	/*队列，循环队列（用的多），双端队列（栈和队列的综合，很少用）*/
	private int len;
	private int[] arr;
	private int front;
	private int rear;
	
	public Queue(int len){
		this.len = len + 1;
		this.arr = new int[len];
		front = 0;
		rear = -1;
		
	}
	
	public void insert(int val){
		if(rear == len - 1)
			rear = -1;
		arr[++rear] = val;
	}
	
	public int remove(){
		int temp = arr[front++];
		if(front == len)
			front = 0;
		return temp;
	}
	
	public boolean isEmpty(){
		return ((front==rear+1) || (front+len-1== rear));
	}
	
	public boolean isFull(){
		return ((front==rear+2) || (front+len-2== rear));
	}
	
	public int size(){
		if(rear >= front) return rear-front+1;
		else return (len-front)+(rear+1);
	}
}

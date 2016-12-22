package book.javaalg.part4;

public class Stack {//java.util.Stack 下边依赖vector
	private int len;
	private int[] arr;
	//private Pair[] parr;
	private int top;
	
	public Stack(int len){
		this.len = len;
		this.arr = new int[len];
		this.top = -1;
	}
	
	public void push(int val){
		if(this.isFull()) throw new StackOverflowError();//
		arr[++top] = val;
	}
	
	public int pop(){
		if(this.isEmpty()) throw new StackOverflowError();
		return arr[top--];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == len - 1;
	}
	
	public static void main(String[] args){
		Stack s = new Stack(20);
		s.push(20);
		s.push(10);
		System.out.print(s.pop());
	}
}

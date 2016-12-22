package book.javaalg.part12;

class Node{
	private int iData;
	
	public Node(int data){
		this.iData = data;
	}
	
	public int getiData() {
		return iData;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}
}

public class BigHeap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public BigHeap(int mx){
		this.maxSize = mx;
		this.currentSize = 0;
		this.heapArray = new Node[mx];
	}
	
	public boolean insert(int key){
		if(currentSize < maxSize){
			Node n = new Node(key);
			heapArray[currentSize++] = n;
			
			trickleUp(currentSize-1);
			return true;
		}
		
		return false;
	}
	
	public Node remove(){
		if(currentSize > 0){
			Node n = heapArray[0];
			heapArray[0] = heapArray[--currentSize];
			trickleDown(0);
			return n;
		}
		
		return null;
	}
	
	public void trickleUp(int index){
		Node temp = heapArray[index];
		while(true){
			int fa = (index-1) >> 1;
			if(fa >= 0 && heapArray[fa].getiData() < temp.getiData()){
				heapArray[index] = heapArray[fa];
				index = fa;
			}else{
				heapArray[index] = temp;
				break;
			}
		}
	}
	
	public void trickleDown(int index){
		Node temp = heapArray[index];
		while(true){
			int left = (index << 1) + 1;
			int right = left + 1;
			if(left < currentSize){
				if(right < currentSize && heapArray[left].getiData() < heapArray[right].getiData()){
					heapArray[index] = heapArray[right];
					index = right;
				} else {
					heapArray[index] = heapArray[left];
					index = left;
				}
			} else {
				heapArray[index] = temp;
				return;
			}
		}
	}
	
	public void heapify(){
		
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public void print(){
		for(int i = 0; i < currentSize; i++)
			System.out.print(heapArray[i].getiData()+" ");
		System.out.println();
	}

	public static void main(String[] args){
		//int[] sortArr = new int[]{1, 2, 3, 5, 4, 6, 9};
		//print(sortArr);
		BigHeap heap = new BigHeap(20);
		heap.insert(24);
		heap.insert(23);
		heap.insert(20);
		heap.insert(12);
		heap.insert(13);
		heap.insert(11);
		heap.insert(10);
		heap.insert(9);
		heap.insert(50);
		heap.insert(25);
		heap.print();
		heap.remove();
		heap.print();
	}
}

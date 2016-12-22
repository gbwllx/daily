package book.javaalg.part7;

public class QuickSort {
	//递归非递归两种，效率差不多
	private static int[] arr;
	/*
	 * 递归方法
	 */
	public static void quickSort(int begin, int end){	
		if(begin < end){
			int mid = partition(begin, end);
			quickSort(begin, mid-1);
			quickSort(mid+1, end);
		}
	}

	public static int partition(int left, int right){
		int key = arr[left];
		while(left < right){
			while(arr[right] > key) right--;
			while(arr[left] < key) left++;
			swap(left, right);
		}
		
		return left;
	}
	
	private static void swap(int begin, int pmin) {
		int temp = arr[begin];
		arr[begin] = arr[pmin];
		arr[pmin] = temp;
	}
	
	
	public static void print(){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args){
		arr = new int[]{1, 2, 3, 4, 5, 6, 9, 10, 13, 20, 23, 77, 88};
		arr = new int[]{9, 8, 7, 6, 4};
		//arr = new int[]{5, 1, 3, 6, 4, 7, 9, 10, 20, 13, 23, 77, 88, 40};
		quickSort(0, arr.length-1);
		print();
	}
}

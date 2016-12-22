package book.javaalg.part3;

public class BubbleSort {
	public static int[] bubbleSort(int[] arr){
		int end = arr.length - 1;
		
		while(end > 0) {
			int begin = 0;
			while(begin < end){
				if(arr[begin] > arr[begin+1]){
					swap(arr, begin);
				}
				begin++;
			}
			end--;
		}
		
		return arr;
	}
	
	private static void swap(int[] arr, int begin) {
		int temp = arr[begin];
		arr[begin] = arr[begin+1];
		arr[begin+1] = temp;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args){
		int[] sortArr = new int[]{1, 2, 3, 5, 4, 6, 9};
		bubbleSort(sortArr);
		print(sortArr);
	}
}

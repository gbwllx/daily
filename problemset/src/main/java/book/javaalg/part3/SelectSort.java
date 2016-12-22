package book.javaalg.part3;

public class SelectSort {
	public static int[] selectSort(int[] arr){
		int begin = 0;
		
		while(begin < arr.length-1) {
			int end = arr.length - 1;
			int minVal = arr[begin];
			int pmin = begin;
			while(begin < end){
				if(arr[end] < minVal){
					minVal = arr[end];
					pmin = end;
				}
				end--;
			}
			swap(arr, begin, pmin);
			begin++;
		}
		
		return arr;
	}
	
	private static void swap(int[] arr, int begin, int pmin) {
		int temp = arr[begin];
		arr[begin] = arr[pmin];
		arr[pmin] = temp;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args){
		int[] sortArr = new int[]{1, 2, 3, 5, 4, 6, 9};
		selectSort(sortArr);
		print(sortArr);
	}
}

package book.javaalg.part3;

public class InsertSort {
	public static int[] insertSort(int[] arr){
		int cur = 1;
		while(cur < arr.length){
			int in = cur;
			int temp = arr[cur];
			while(in > 0 && arr[in-1] >= temp){
				arr[in] = arr[in-1];
				in--;
			}
			arr[in] = temp;
			cur++;
		}
		
		return arr;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args){
		int[] sortArr = new int[]{1, 2, 3, 5, 4, 7, 8, 6, 9};
		insertSort(sortArr);
		print(sortArr);
	}
}

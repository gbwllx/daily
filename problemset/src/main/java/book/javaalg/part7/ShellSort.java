package book.javaalg.part7;


public class ShellSort {
	public static void shellSort(int[] arr){
	int step = 1;
	while(step <= arr.length/3)
	{
		step = step*3 + 1;
	}
	
	while(step > 0){
		for(int i = step; i < arr.length; i++){
			int j = i;
			int temp = arr[j];
			while(j > step-1 && temp < arr[j-step]){
				arr[j] = arr[j-step];
				j-=step;
			}
			arr[j] = temp;
		}
		step = (step-1) / 3;
	}
}
	
//	public static void shellSort(int[] arr){
//		int step = 1;
//		while(step <= arr.length/3)
//		{
//			step = step*3 + 1;
//		}
//		
//		while(step > 0){
//			for(int i = step; i < arr.length; i++){
//				int j = i;
//				while(j > step-1 && arr[j] < arr[j-step]){
//					swap(arr, j, j-step);
//					j-=step;
//				}
//			}
//			step = (step-1) / 3;
//		}
//	}
	
//	private static void swap(int[] arr, int begin, int pmin) {
//		int temp = arr[begin];
//		arr[begin] = arr[pmin];
//		arr[pmin] = temp;
//	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static void main(String[] args){
		int[] sortArr = new int[]{1, 2, 3, 5, 4, 6, 9};
		shellSort(sortArr);
		print(sortArr);
	}
}

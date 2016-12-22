package book.javaalg.part2;

public class BinarySearch {
	public static int binarySearch(int[] sortArr, int key){
		int start = 0;
		int end = sortArr.length-1;
		
		while(end >= start){
			int mid = (start + end) >> 1;
			if(sortArr[mid] == key) {
				return mid;
			} else if(sortArr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return sortArr.length;
	}
	
	public static void main(String[] args){
		int[] sortArr = new int[]{1, 2, 3, 4, 6, 9};
		System.out.println(binarySearch(sortArr, 9));
	}
}

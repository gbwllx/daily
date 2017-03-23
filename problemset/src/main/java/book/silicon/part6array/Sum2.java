package book.silicon.part6array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *	0. 时间复杂度当然越低越好
 *
	1. 是否允许对原数组的修改
 	2. 对空间复杂度是否有要求
 */
public class Sum2 {
	/*
	 * 对每个数遍历一次，直到找到，时间复杂度O(N2)，空间复杂度O(1)
	 */
	public static void sum21(int[] arr, int dest){
		System.out.println("sum21:");
		if(arr != null && arr.length >= 2){
			for(int i = 0; i < arr.length; i++){
				for(int j = i + 1; j < arr.length; j++){
					if(arr[i]+arr[j] == dest){
						print(arr, i, j);
						return;
					}
				}
			}
		}
		System.out.print("none");
	}

	/*
	 * 	扫描一遍存入hashmap，判断差值是否在表中，时间复杂度O(N)，空间复杂度O(N)
	 */
	public static void sum22(int[] arr, int dest){
		System.out.println("sum22:");
		if(arr != null && arr.length >= 2){
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i = 0; i < arr.length; i++){
				map.put(arr[i], i);
			}
			
			for(int i = 0; i < arr.length; i++){
				int key = dest - arr[i];
				if(map.containsKey(key) && key != arr[i]){
					int j = map.get(key);
					print(arr, i, j);
					return;
				}
			}
		}
		System.out.print("none");
	}
	
	/*
	 * 	先排序O(NlogN)，再二分查找O(NlogN),时间复杂度O(NlogN),空间复杂度O(1),缺点改变原数组结构
	 */
	public static void sum23(int[] arr, int dest){
		System.out.println("sum23:");
		if(arr != null && arr.length >= 2){
			Arrays.sort(arr);
			for(int i = 0; i < arr.length; i++){
				int key = dest - arr[i];
				int j = Arrays.binarySearch(arr, key);
				if(j >= 0){
					print(arr, i, j);
					return;
				}
			}
		}

		System.out.print("none");
		/*for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		*/
	}
	
	private static void print(int[] arr, int i, int j) {
		System.out.println(i + ":" + arr[i]);
		System.out.println(j + ":" + arr[j]);
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{2, 3, 1, 4, 6, 9, 8, 10, 22, 33, 44, 23, 34, 25, 11};
		sum21(arr, 7);
		sum22(arr, 21);
		sum23(arr, 20);
	}
}

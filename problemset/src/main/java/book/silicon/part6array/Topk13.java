package book.silicon.part6array;

import java.util.Arrays;

/**
 * description: 给定一数组与k，找出和不小于k的数目最少的子数组
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class Topk13 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 14, 15, 3, 4, 5, 7, 6, 8, 9, 10, 11, 12, 13};

        int k = 42;
        for (int i : topk(arr, k)) {
            System.out.println(i);
        }
    }

    private static int[] topk(int[] arr, int k) {
        return null;
    }


}

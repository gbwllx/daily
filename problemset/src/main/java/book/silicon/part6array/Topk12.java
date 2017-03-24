package book.silicon.part6array;

import java.util.Arrays;

/**
 * description:
 * 做题前需明确
 * 1. 机器内容是否能容纳整个数组
 * 2. 最小的k个数是否要求有序
 * 3. 能否修改输入数组
 * 4. 时间复杂度O(nlgn)还是O(n)
 * <p>
 * 方案1：
 * 排序，如果装不下需要外部排序 O(nlgn)
 * 方案2：
 * 堆O(nlgk)
 * 方案3：
 * 快排分区，因为只分区，没快排，所以复杂度是O(n)
 * <p>
 * 重点：广泛应用于面试题中，5分钟内能写出
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class Topk12 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 14, 15, 3, 4, 5, 7, 6, 8, 9, 10, 11, 12, 13};

        int k = 5;
        for (int i : topk(arr, k)) {
            System.out.println(i);
        }
    }

    //可以写partition算法，也可以直接这样写,还是写partition吧，感觉下边的有bug
    //不支持重复数据
    private static int[] topk(int[] arr, int k) {
        int n = arr.length;
        int pivot = arr[n / 2];
        int first = 0, last = n - 1;
        int rangeF = 0, rangeT = n - 1;
        while (first != k) {
            while (first < last) {
                while (arr[first] < pivot) {
                    first++;
                }
                while (arr[last] > pivot) {
                    last--;
                }
                int temp = arr[last];
                arr[last] = arr[first];
                arr[first] = temp;
            }
            if (first > k) {
                first = rangeF;
                rangeT = last;
            } else if (first < k) {
                last = rangeT;
                rangeF = first;
            }
            pivot = arr[(last - first) / 2 + rangeF];
        }
        return Arrays.copyOfRange(arr, 0, k);
    }
}

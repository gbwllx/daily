package book.silicon.datastructure.part6array;

/**
 * description:
 * 1. 数组反转：    向右旋转K个位置，原数组{1,2,3,4,5}，k=2时，新数组{4,5,1,2,3}
 * 要求：        常量级空间复杂度，允许修改原数组
 * 思路： 如果允许空间复杂度为N，可以错位复制
 * 如果允许修改原数组，3次反转
 * <p>
 * 2. reverse函数的实现
 * 3. swap函数的实现
 * author: gubing.gb
 * date: 2017/2/12.
 */
public class A4Rotate {
    public static int[] rotateK(int[] arr, int k) {
        if (arr == null || k >= arr.length) return arr;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);

        return arr;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    //异或
    private static void swap(int[] arr, int start, int end) {
        arr[start] = arr[start] ^ arr[end];
        arr[end] = arr[start] ^ arr[end];
        arr[start] = arr[start] ^ arr[end];
    }

    //原始
    private void swap1(int[] arr, int start, int end) {
        int t;
        t = arr[start];
        arr[start] = arr[end];
        arr[end] = t;
    }

    //不用，思路：乘法
    private static void swap2(int[] arr, int start, int end) {
        arr[start] = arr[start] * arr[end];
        arr[end] = arr[start] / arr[end];
        arr[start] = arr[start] / arr[end];
    }

    //不用，思路：加法
    private static void swap3(int[] arr, int start, int end) {
        arr[start] = arr[start] + arr[end];
        arr[end] = arr[start] - arr[end];
        arr[start] = arr[start] - arr[end];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //swap(arr, 1, 2);
        rotateK(arr, 6);

        for (int i : arr) {
            System.out.println(i);
        }

    }
}

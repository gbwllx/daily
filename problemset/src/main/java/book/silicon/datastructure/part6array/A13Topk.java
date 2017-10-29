package book.silicon.datastructure.part6array;

/**
 * description: 给定一数组与k，找出和不小于k的数目最少的子数组
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class A13Topk {
    public static void main(String[] args) {
        int arr[] = new int[] {5, 2, 14, 15, 3, 4, 1, 7, 6, 8, 9, 10, 11, 12, 13};

        int k = 42;
        System.out.println("topk:" + topk(arr, k));
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int topk(int[] arr, int k) {
        int index = partition(arr, 0, arr.length - 1);
        int sum = sum(arr, index);
        while (index >= 0) {
            if (sum < k) {
                index = partition(arr, 0, index - 1);
            } else {
                index = partition(arr, index + 1, arr.length - 1);
            }
        }

        return index;
    }

    private static int sum(int[] arr, int index) {
        int sum = 0;
        for (int i = index; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && array[j] >= pivot) {j--;}
            while (i < j && array[i] <= pivot) {i++;}

            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, i, left);
        return i;
    }

    //算法导论上的，不太好，交换次数太多
    //    private static int[] partition(int[] array, int left, int right) {
    //        int i = left - 1;
    //        int j = left;
    //        int pivot = array[right];
    //
    //        for (; j < right; j++) {
    //            if (array[j] < pivot) {
    //                i++;
    //                if (i == j) continue;
    //                int tem = array[i];
    //                array[i] = array[j];
    //                array[j] = tem;
    //            }
    //        }
    //
    //        int tem = array[i + 1];
    //        array[i + 1] = array[right];
    //        array[right] = tem;
    //        return array;
    //    }

    private static void swap(int[] arr, int begin, int end) {
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

}

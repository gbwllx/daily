package book.silicon.datastructure.part6array;

/**
 * description: 旋转数组搜索（不含重复数据）
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A17FindTargetOfRotation {
    public static int searchRotatedArray(int a[], int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) { return mid; }
            //左半部分是有序的
            if (a[left] <= a[mid]) {
                if (a[left] <= target && target < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右半部分是有序的
                if (a[mid] < target && target <= a[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

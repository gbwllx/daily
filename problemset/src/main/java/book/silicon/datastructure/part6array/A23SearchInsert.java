package book.silicon.datastructure.part6array;

/**
 * description: 给定一格有序数组和一个目标值，插入到有序位置，返回下标
 * 无重复数据
 * 如果存在直接返回下标
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A23SearchInsert {
    int searchInsert(int a[], int target){
        int low = 0;
        int high = a.length-1;
        int mid;
        while (low <= high) {
            mid = (low+high) / 2;
            if (a[mid] == target) {
                return mid;
            } else if(a[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        //返回第一个大于目标值的元素的下标
        return low;
    }
}

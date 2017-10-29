package book.silicon.datastructure.part6array;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A16FindMinOfRotation {
    public static int getMinOfRotation(int a[]) {
        int left = 0, right = a.length - 1;
        int mid;
        int min = a[left];
        while (left < right) {
            mid = left + (right - left) / 2;
            min = Math.min(a[left], min);
            if (a[mid] == a[left] && a[mid] == a[right]) {
                //不能确定最小值在哪一部分，向前移动一格；
                left++;
            } else if (a[mid] >= a[left]) {
                //在右半部分查找
                left = mid + 1;
                min = Math.min(a[left], min);
            } else {
                //在左半部分查找
                min = Math.min(a[mid], min);
                right = mid - 1;
            }
        }

        return min;
    }
}

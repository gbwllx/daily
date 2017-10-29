package book.silicon.datastructure.part6array;

/**
 * description: 查找两数组第k个值
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A14FindKth {
    public static void main(String[] args) {
        int arra[] = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13};
        int arrb[] = new int[]{14, 15, 16, 17};

        int k = 5;
        System.out.println(findKthSortedArrays(arra, arrb, k));
    }

    /**
     * 时间复杂度O(log(min(m,n)))
     *
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int findKthSortedArrays(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        if (m > n) { return findKthSortedArrays(b, a, k);}
        int left = 0;
        int right = m;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int j = k - 1 - mid;
            if (j >= n || a[mid] < b[j]) {
                //小标i尽可能往前移动，找到比B[j]大的第一个A[i]
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int aiminus1 = left - 1 >= 0 ? a[left - 1] : Integer.MIN_VALUE;
        int bj = k - 1 - left >= 0 ? b[k - 1 - left] : Integer.MIN_VALUE;

        return Math.max(aiminus1, bj);
    }
}

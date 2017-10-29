package book.silicon.datastructure.part6array;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/18.
 */
public class A21SearchMatrix {
    boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                //在右半部分继续找
                low = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                high = mid - 1;
            }
        }
        return false;
    }
}

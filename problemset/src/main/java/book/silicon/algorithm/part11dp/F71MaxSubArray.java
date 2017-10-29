package book.silicon.algorithm.part11dp;

/**
 * description: 数组最大和
 * 输入一个数组a，求其连续子数组的最大和
 * currMax = Math.max(a[i],currMax+a[i])
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F71MaxSubArray {
    public int maxSubArray(int[] a) {
        if (a == null || a.length == 0) { return 0; }
        int currMax = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            //以当前位置结束的子序列之和
            currMax = Math.max(a[i], currMax + a[i]);
            //保留最大值
            max = Math.max(max, currMax);
        }

        return max;
    }
}

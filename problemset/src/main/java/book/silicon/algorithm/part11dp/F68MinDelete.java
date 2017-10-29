package book.silicon.algorithm.part11dp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * description: 最长递增子序列
 * 给出一个数组，找出最少元素，使得将其删除之后，剩下的元素是递增有序的
 * 即：找出最长的递增子序列，最后通过回溯哈希表，把需要删除的元素删除
 * 1.dp[i] = 1,初始化时每个元素构成一个序列
 * 2. dp[i] = max(dp[i],dp[j]+1),其中j<i,并且a[i]>=a[j]
 *
 * @author: gubing.gb
 * date: 2017/10/26.
 */
public class F68MinDelete {
    ArrayList<Integer> minDelete(int[] a) {
        ArrayList<Integer> res = new ArrayList<>();
        //通过倒序追踪记录最长的递增子序列
        HashMap<Integer, Integer> bt = new HashMap<>();
        //记录每个元素为结尾的最长子序列长度
        int[] dp = new int[a.length];
        int maxCount = 0;
        //最长递增子序列的最后一个元素
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (maxCount < dp[i]) {
                        maxCount = dp[i];
                        bt.put(i, j);
                        end = i;
                    }
                }
            }
        }

        int k = a.length - 1;
        while (k >= 0) {
            //加入需要被删除的元素
            while (k > end) {
                res.add(a[k]);
                k--;
            }
            k--;
            if (bt.containsKey(end)) {
                //求出LIS的上一个元素
                end = bt.get(end);
                //LIS到头了
            } else { end = -1;}
        }
        return res;
    }
}

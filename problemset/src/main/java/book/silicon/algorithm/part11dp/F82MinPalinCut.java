package book.silicon.algorithm.part11dp;

/**
 * description:回文分割
 * 给出一个字符串s，将s进行分割，使得每个子串均为回文。求最少分割数
 * 举例：输入s=abb，可能的分割结果[a, b, b]; [a, bb]。那么最少分割数为1， 即[a,bb]
 *
 * 1. isPa[i][j] = isPa[i+1][j-1]，当s[i] 与s[j]相等时
 * 2. isPa[i][j] = false, 当s[i]与s[j]不相等时
 *
 * @author: gubing.gb
 * date: 2017/10/29.
 */
public class F82MinPalinCut {
    int minPalinCut(String s) {
        int len = s.length();
        int dp[] = new int[len + 1];
        boolean isPa[][] = new boolean[len][len];
        //初始化从i到结束的字符串的回文分割数
        for (int i = 0; i <= len; i++) {
            dp[i] = len - i - 1;
        }

        for (int i = len -1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                //判断从i到j是否为回文，如果是，更新最小分割数
                if (s.charAt(i) == s.charAt(j) && (j-i<2||isPa[i+1][j-1])){
                    isPa[i][j] = true;
                    //dp[i] 取dp[i]与dp[j+1]+1的较小值
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }

        return dp[0];
    }
}

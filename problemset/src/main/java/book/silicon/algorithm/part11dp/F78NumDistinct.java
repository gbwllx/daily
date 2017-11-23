package book.silicon.algorithm.part11dp;

/**
 * description: 子串个数
 * 输入两个字符串S和T，求出T在S的子序列个数
 *
 * 举例： S=Exampple T = Example， T在S的子序列个数为2
 * 1. dp[i][j] = dp[i-1][j]+dp[i-1][j-1]，当S的第i个字符和T的第j个字符相等
 * 2. dp[i][j] = dp[i-1][j]，当上述条件不成立时
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F78NumDistinct {
    int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen == 0 || tLen == 0 || tLen > sLen) {
            return 0;
        }
        int[][] dp = new int[sLen + 1][tLen + 1];
        //初始化边界条件
        for (int i = 0; i <= sLen; i++) {dp[i][0] = 1;}
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //如果s的第i个字符与t的第j个字符相等
                    //需要加上dp[i-1][j-1]结果
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}

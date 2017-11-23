package book.silicon.algorithm.part11dp;

/**
 * description: 最大公共子串
 * 给出两个字符串s1和s2,返回其最大的公共子串
 *
 * 1. dp[i][j]=dp[i-1][j-1]+1，当s[i]与s[j]相等时
 * 2. dp[i][j] = 0,当s[i]与s[j]不相等时
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F83LCS {
    public String LCS(String s1, String s2) {
        String res = "";
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return res;
        }
        int max = 0, m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        //计算到s1的第i个字符和s2的第j个字符为止的最长公共子串
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {dp[i][j] = 1;} else {dp[i][j] = dp[i - 1][j - 1] + 1;}
                    //记录最大长度和子串
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        res = s1.substring(i - dp[i][j] + 1, i + 1);
                    }
                }
            }
        }
        return res;
    }
}

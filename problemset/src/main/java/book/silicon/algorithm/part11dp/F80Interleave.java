package book.silicon.algorithm.part11dp;

/**
 * description: 交替字符串
 * 输入三个字符串s1,s2和s3，判断s3是否由s1和s2的字符组成，字符保持原有的相对顺序
 *
 * 举例：假设s1="abc",s2="def"如果s3="adbecf",返回true；如果s3=“abcdee”，返回false
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F80Interleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), s = s3.length();
        //如果长度不一致，s3不可能由s1和s2组成
        if (m + n != s) { return false; }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (dp[i][j] || (i - 1 >= 0 && dp[i - 1][j] == true && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                    || (j - 1 >= 0 && dp[i][j - 1] == true && s1.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

}

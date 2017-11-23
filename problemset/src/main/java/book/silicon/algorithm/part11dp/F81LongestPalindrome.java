package book.silicon.algorithm.part11dp;

/**
 * description: 输入一字符串S，找出其最长回文子串
 * 1. dp[i][j] = dp[i+1][j-1]，当s[i]与s[j]相等时
 * 2. dp[i][j] = false, 当s[i]与s[j]不相等时
 *
 * 动态规划的算法复杂度是O(n2)，还有一种将每个位置作为中心点遍历的Manacher方法
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F81LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length(), longestBegin = 0, maxLen = 1;
        boolean dp[][] = new boolean[n][n];
        //单个字符是回文
        for (int i = 0; i < n; i++) {dp[i][i] = true;}
        //紧挨着的两个相同字符也是回文
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    //如果两端字符相同，那取决于内部子串的情况
                    dp[i][j] = true;
                    longestBegin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        //截取回文
        return s.substring(longestBegin, longestBegin + maxLen);
    }
}

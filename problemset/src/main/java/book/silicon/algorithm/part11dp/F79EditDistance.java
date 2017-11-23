package book.silicon.algorithm.part11dp;

/**
 * description: 编辑距离
 * 输入两个单词word1和word2，求出从word1转为word2的最少步骤
 * 每个转换操作算一步。转换操作限定于：删除一个字符，插入一个字符，替换一个字符
 * 1. dp[i][j] = dp[i-1][j-1],当word1[i-1]字符与word2[j-1]字符相等
 * 2. dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]),当上述条件不成立，取修改，删除word1字符，删除word2字符的最小值
 *
 * @author: gubing.gb
 * date: 2017/10/29.
 */
public class F79EditDistance {
    int editDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) {return len2;}
        if (len2 == 0) {return len1;}

        int dp[][] = new int[len1 + 1][len2 + 1];
        //初始化边界，只有word1的字符
        for (int i = 0; i <= len1; i++) {dp[i][0] = i;}
        //初始化边界，只有word2的字符
        for (int j = 0; j <= len2; j++) {dp[0][j] = j;}
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

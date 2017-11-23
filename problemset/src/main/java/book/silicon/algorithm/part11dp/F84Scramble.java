package book.silicon.algorithm.part11dp;

/**
 * description: 字符串洗牌
 * 给定两个相同长度的字符串s1和s2,判断s2是否是s1翻洗后的字符串
 * 我们使用二叉树来存储字符串，每个节点一分为二。子节点为非空的子串。
 * 翻转非叶节点的两个子节点后，组成新的字符串，我们称为翻洗后的字符串
 * author: gubing.gb
 * date: 2017/10/30.
 */
public class F84Scramble {
    boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n) {return false;}
        boolean dp[][][] = new boolean[n][n][n];
        //初始化长度为1的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        //计算长度为l的情况
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + 1 < n; i++) {
                for (int j = 0; j + 1 < n; j++) {
                    for (int k = 0; k < l; k++) {
                        if ((dp[i][j][k] && dp[i + k + l][j + k + l][l - 1 - k])
                            || (dp[i][j + l - k])[k] && dp[i + k + l][j][l - 1 - k]) {
                            dp[i][j][l] = true;
                            break;
                            //只要找出符合条件的一种情况即可
                        }
                    }
                }
            }
        }
        //返回长度为n的情况
        return dp[0][0][n - 1];
    }
}

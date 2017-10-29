package book.silicon.algorithm.part11dp;

/**
 * description: 数字解码
 * 给只含有a到z字符的字符串加密，加密规则为'a'-1,'b'-2,'z'-26。现有一个已经加过密的密文（仅含有数字）。
 * 举例:x现有密文“26”，他可以解密为“Z”或者"BF"，两种解法，最多也就两种了
 *
 * 求其解密的方法个数
 * 1. dp[i] = 0, 当s[i]=0时
 * 2. dp[i] = dp[i+1]+dp[i+2]，当和后面字符组成数字小于等于26时
 * 3. dp[i] = dp[i+1]，当上面条件不成立时
 * author: gubing.gb
 * date: 2017/10/29.
 */
public class F77NumDecodings {
    int numDecodings(String s) {
        if (s.length() == 0) {return 0;}
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                //当遇到一个0时，没有办法破解
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }

            //如果和后面的字符组成的数小于等于26，
            //那么认为当前两个字符时一种解码方案，故加上dp[i+2]
            if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                dp[i] += dp[i + 2];
            }

        }
        return dp[0];
    }
}

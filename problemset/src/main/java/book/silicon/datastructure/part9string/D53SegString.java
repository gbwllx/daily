package book.silicon.datastructure.part9string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D53SegString {
    int segString(String s, HashSet<String> d) {
        if (s == null || s.length() == 0) {return 0;}
        //初始化为零
        int dp[] = new int[s.length()];
        //记录从0到i的子串是否为字典里的单词
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (d.contains(sub)) {
                //如果整个串是一个单词则为1
                dp[i] = 1;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[i] > 0) {
                    //如果i之前的能分割成单词，那么考虑i+1到j的情况
                    String sub = s.substring(i + 1, j + 1);
                    if (d.contains(sub)) {
                        //如果i+1到j也是一个单词，那么更新从0到j的最大单词数
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}

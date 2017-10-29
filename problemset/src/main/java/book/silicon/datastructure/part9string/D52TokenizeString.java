package book.silicon.datastructure.part9string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D52TokenizeString {
    /**
     * @param input
     * @param d         单词字典
     * @param memorized
     * @return
     */
    ArrayList<String> tokenizeString(String input, HashSet<String> d,
                                     HashMap<String, ArrayList<String>> memorized) {
        ArrayList<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) {return res;}
        //从已保存的结果中找出提取后的单词，加快提取速度
        if (memorized.containsKey(input)) {
            return memorized.get(input);
        }
        //如果整个串就是一个单词，将其加入结果
        if (d.contains(input)) {
            res.add(input);
        }
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (d.contains(prefix)) {
                //如果这个前缀是一个单词，递归调用函数
                for (String segSuffix : tokenizeString(input.substring(i, len), d, memorized)) {
                    if (segSuffix != null) {
                        res.add(prefix + " " + segSuffix);
                    }
                }
            }
        }
        memorized.put(input, res);
        return res;
    }
}

package book.silicon.datastructure.part9string;

/**
 * description: ASC2字符集
 * 字符判重需要看编码
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class D50UniqueChars {
    public boolean isUniqueChars(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {return false;}
            char_set[val] = true;
        }
        return true;
    }
}

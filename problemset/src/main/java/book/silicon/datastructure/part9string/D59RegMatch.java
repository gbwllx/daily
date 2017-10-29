package book.silicon.datastructure.part9string;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D59RegMatch {
    boolean isMatch(String s, String p) {
        if (s == null) {return p == null;}
        if (p == null) {return false;}
        return isMatch(s, p, 0, 0);
    }

    boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) {return i == s.length();}
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length()) {return false;}
            return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && isMatch(s, p, ++i, ++j);
        }
        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            if (isMatch(s, p, i, j + 2)) {return true;}
            i++;
        }
        return isMatch(s, p, i, j + 2);
    }
}

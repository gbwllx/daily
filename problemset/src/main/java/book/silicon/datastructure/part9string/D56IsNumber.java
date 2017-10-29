package book.silicon.datastructure.part9string;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D56IsNumber {
    public boolean isNumber(String s) {
        boolean res = false;
        if (s == null) {return res;}
        s = s.trim();
        if (s.equals("")) {return res;}
        boolean hasSign = false, hasDot = false;
        boolean hasExp = false, hasDigit = false;
        s = s.toLowerCase();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isValid(c)) {return false;}
            switch (c) {
                case '+':
                case '-':
                    if ((i != 0 && s.charAt(i - 1) != 'e') || i == len - 1) {
                        return false;
                    } else {
                        hasSign = true;
                    }
                    break;
                case '.':
                    if (len == 1 || (len == 2 && hasSign) || hasExp || hasDot) {
                        return false;
                    } else {
                        hasDot = true;
                    }
                case 'e':
                    if (i == 0 || i == len - 1 || !hasDigit || hasExp) {
                        return false;
                    } else {
                        hasExp = true;
                    }
                    break;
                default:
                    hasDigit = true;
                    break;
            }
        }
        return true;
    }

    public boolean isValid(char c) {
        if (c == '+' || c == '-' || c == '.' || c == 'e' || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}

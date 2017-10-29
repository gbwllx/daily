package book.silicon.datastructure.part9string;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D57Atoi {
    int atoi(String str) {
        if (str == null || str.length() == 0) {return 0;}
        boolean isNeg = false;
        str = str.trim();
        int p = 0;
        if (str.charAt(p) == '-') {
            isNeg = true;
            p++;
        } else if (str.charAt(p) == '+') {
            isNeg = false;
            p++;
        }

        int num = 0;
        char c;
        while (p < str.length()) {
            c = str.charAt(p);
            if (c < '0' || c > '9') {break;}
            if ((num == 214748364 && (c - '0') > 7) || (num > 214748364)) {
                return (!isNeg) ? Integer.MAX_VALUE : Integer.MAX_VALUE;
            }
            num = 10 * num + (c - '0');
            ++p;
        }
        return (!isNeg) ? num : -num;
    }
}

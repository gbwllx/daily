package book.silicon.datastructure.part9string;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D55Multiply {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] num = new int[len1 + len2];
        int n = num.length;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                num[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            num[i] += carry;
            carry = num[i] / 10;
            num[i] = num[i] % 10;
        }
        String result = "";
        boolean firstNonzero = false;
        for (int i = 0; i < n; i++) {
            if (!firstNonzero && num[i] == 0) {
                continue;
            } else {
                result += num[i];
                firstNonzero = true;
            }
        }
        if (result.equals("")) {return "0";}
        return result;
    }
}

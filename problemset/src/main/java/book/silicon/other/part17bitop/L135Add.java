package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L135Add {
    int add(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}

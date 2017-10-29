package book.silicon.other.part17bitop;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class L136BitSet {
    long[] bits;

    L136BitSet(int numBits) {
        int numLongs = numBits >>> 6;
        if ((numBits & 0x3F) != 0) {
            numLongs++;
        }
        bits = new long[numLongs];
    }

    private L136BitSet(long[] bits) {
        this.bits = bits;
    }

    boolean get(int index) {
        return (bits[index >>> 6] & 1L << (index & 0x3F)) != 0L;
    }

    void set(int index) {
        bits[index >>> 6] |= 1L << (index & 0x3F);
    }

    void clear(int index) {
        bits[index >>> 6] &= ~(1L << (index & 0x3F));
    }
}

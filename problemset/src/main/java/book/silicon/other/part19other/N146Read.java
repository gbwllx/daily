package book.silicon.other.part19other;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class N146Read {
    //int read(char[] buf, int n) {
    //    int num = n / 4096;
    //    int remain = n % 4096;
    //    int total = 0;
    //    while (num-- > 0) {
    //        int num_read = read4096(buf);
    //        if (num_read == 0) { break;}
    //        buf += num_read;
    //        total+=num_read;
    //    }
    //    if (total != n-remain) {return total;}
    //    char readbuf[] = new char[4096];
    //    int num_read = read4096(readbuf);
    //    int num_copy = Math.min(num_read, remain);
    //    memcpy(buf, readbuf, num_copy);
    //    total += num_copy;
    //    return total;
    //}

    private int read4096(char[] buf) {
        return 0;
    }
}

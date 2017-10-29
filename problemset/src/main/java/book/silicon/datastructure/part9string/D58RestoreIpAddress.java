package book.silicon.datastructure.part9string;

import java.util.ArrayList;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class D58RestoreIpAddress {
    ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        String ip = "";
        restoreIpAddresses(s, 0, 0, ip, res);
        return res;
    }

    /**
     * @param s
     * @param start
     * @param part  指第几段，ip一共4段
     * @param ip
     * @param res
     */
    void restoreIpAddresses(String s, int start, int part, String ip, ArrayList<String> res) {
        if (s.length() - start > (4 - part) * 3) {return;}
        if (s.length() - start < (4 - part)) {return;}
        if (start == s.length() && part == 4) {
            //去掉最后一个'.'
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }
        int num = 0;
        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num <= 255) {
                ip += s.charAt(i);
                restoreIpAddresses(s, i + 1, part + 1, ip + '.', res);
            }
            if (num == 0) {break;}
        }
    }
}

package book.silicon.datastructure.part6array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 给两个数组表示的整数，返回第一个整数重组后最接近第二个数，并且大于第二个数的数
 * 假设两个数组大小相同，并且一定能找到符合条件的数
 * 例：输入{1,2,3,4}{2,4,1,0}
 * 返回{2,4,1,3}
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class A10ClosestBigger {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{2, 4, 1, 0};

        for (int i : getClosestBig(arr1, arr2)) {
            System.out.print(i);
        }
    }

    private static Integer[] getClosestBig(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] flag = new int[arr1.length];
        List res = new ArrayList();

        //和原来一样的，放到原位，遇到比原来大的第一位即结束
        loop:
        for (int i : arr2) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == i && flag[j] == 0) {
                    flag[j] = 1;
                    res.add(i);
                    break;
                } else if (arr1[j] > i && flag[j] == 0) {
                    flag[j] = 1;
                    res.add(arr1[j]);
                    break loop;
                }
            }
        }

        //剩余的按序放入，从小到大排序保证是最小序列
        for (int j = 0; j < arr1.length; j++) {
            if (flag[j] == 0) {
                res.add(arr1[j]);
            }
        }

        return (Integer[]) res.toArray(new Integer[res.size()]);
    }
}

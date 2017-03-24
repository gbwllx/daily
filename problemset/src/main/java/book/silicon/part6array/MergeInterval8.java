package book.silicon.part6array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * description: 给定一个区间集合，合并里面的重叠区间，并返回新的不含重叠区间
 * 例：输入[1,5][6,10][4,6][15,20]
 * 输出：[1,10][15,20]
 * <p>
 * 关注：1.原数组没给定顺序，2.输出没有要求顺序，可先排序
 * author: gubing.gb
 * date: 2017/3/23.
 */
public class MergeInterval8 {
    public static void main(String[] args) {
        Interval[] arr = new Interval[]{new Interval(1, 5), new Interval(6, 10), new Interval(4, 6), new Interval(15, 20), new Interval(30, 40)};
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.start > o2.start || (o1.start == o2.start && o1.end > o2.end)) {
                return 1;
            }
            return -1;
        });
        arr = mergeInterval(arr);
        for (Interval interval : arr) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }

    //比人家写的搓多了，继续学习
    private static Interval[] mergeInterval(Interval[] arr) {
        List list = new ArrayList<>();
        int i = 1, n = arr.length;

        //排完序只有两种情况（1种连续情况），处理外循环
        while (i < n) {
            if (arr[i - 1].end < arr[i].start) {
                list.add(arr[i - 1]);
                i++;
            } else {
                //处理子连续
                while (i < n) {
                    //1.要想少写代码，就会多出来重复的判断（只有一次，其实没什么影响，但是代码少了很多）
                    //2.少写代码大概率破坏原数组的数据
                    if (arr[i - 1].end >= arr[i].start) {
                        arr[i].start = arr[i - 1].start;
                        arr[i].end = Math.max(arr[i - 1].end, arr[i].end);
                    } else {
                        break;
                    }
                    i++;
                }
            }
        }

        list.add(arr[n - 1]);
        return (Interval[]) list.toArray(new Interval[list.size()]);
    }

    //given version，一下程序是有问题的，但是提出来一个current指针还不是直接用i的思想要学习一下
    private static Interval[] merge(Interval[] arr) {
        List list = new ArrayList<>();
        if (arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            Interval current = arr[i];
            if (list.isEmpty()) {
                list.add(current);
            } else {
                Interval last = arr[arr.length - 1];
                if (last.end >= current.start) {
                    last.end = Math.max(last.end, current.end);
                } else {
                    list.add(current);
                }
            }

        }

        return (Interval[]) list.toArray(new Interval[list.size()]);
    }

    static class Interval {
        int start;
        int end;

        Interval(int a, int b) {
            this.start = a;
            this.end = b;
        }
    }
}

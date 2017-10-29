package book.silicon.datastructure.part6array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 给定一个没有重叠区间的序列，插入一个新的区间，保持没有重叠的情况
 * 假设该序列存放的区间是有序的，有序就简单很多 （四种相交的形式，两种不相交的形式）
 * 例：已有两个[1,5][6,10] 现插入一个新的[4,6]，最后的结果是[1,10]
 * <p>
 * 我的想法是在原数组上做减法，给的解法是做加法。原因估计是：
 * 之前我不想添加一个辅助数组，后来没办法了才添加的，导致做的减法，
 * 以后碰到这个问题先用辅助数组，哪怕之后再优化
 * author: gubing.gb
 * date: 2017/2/12.
 */
public class A7InsertInterval {
    public static void main(String[] args) {
        Interval[] arr = new Interval[]{new Interval(1, 2), new Interval(3, 4), new Interval(6, 10)};
        Interval newInt = new Interval(2, 6);
        arr = insertInterval(arr, newInt);
        for (Interval interval : arr) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }

    /**
     * my solution, really different from the given solution
     * my thought is straight, still away from the program thought
     *
     * @param intervals
     * @param newInt
     * @return
     */
    public static Interval[] insert(Interval[] intervals, Interval newInt) {
        List list = new ArrayList(Arrays.asList(intervals));
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start <= newInt.start && newInt.start <= interval.end && interval.end <= newInt.end) {
                newInt.start = interval.start;
                list.remove(interval);
            } else if (interval.start <= newInt.start && newInt.end <= interval.end) {
                newInt.start = interval.start;
                newInt.end = interval.end;
                list.remove(interval);
                break;
            } else if (newInt.start <= interval.start && interval.start <= newInt.end && newInt.end <= interval.end) {
                newInt.end = interval.end;
                list.remove(interval);
                break;
            } else if (newInt.start <= interval.start && interval.end <= newInt.end) {
                list.remove(interval);
            } else {
                count++;
            }
        }
        list.add(count, newInt);
        return (Interval[]) list.toArray(new Interval[list.size()]);
    }

    /**
     * the given solution, this is to add, not to sub
     * better than mine
     */
    public static Interval[] insertInterval(Interval[] intervals, Interval newInt) {
        List list = new ArrayList();

        if (intervals == null) {
            list.add(newInt);
            return (Interval[]) list.toArray(new Interval[list.size()]);
        }

        int i = 0, n = intervals.length;
        //加入非重叠区间
        while (i < n && newInt.start > intervals[i].end) {
            list.add(intervals[i++]);
        }
        //合并重叠区间
        while (i < n && newInt.end >= intervals[i].start) {
            newInt.end = Math.max(newInt.end, intervals[i].end);
            newInt.start = Math.min(newInt.start, intervals[i].start);
            i++;
        }
        //加入合并后区间
        list.add(newInt);
        //加上剩余部分
        while (i < n) {
            list.add(intervals[i++]);
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

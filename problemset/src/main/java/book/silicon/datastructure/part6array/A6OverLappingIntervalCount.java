package book.silicon.datastructure.part6array;

import java.util.Arrays;

/**
 * description: 给定多个可能重叠的区间，找出重叠区间的个数
 *  难点：
 *  1. 什么是重叠区间
 *  2. 怎么计算重叠个数
 * <p>
 * 根据区间起止点排序，start1-start2-start3-end1-end2-end3-start4-end4
 * 遇到start重叠个数加1，记录重叠个数最大值
 * 遇到end重叠个数减1
 * <p>
 * class Interval{
 * int start;
 * int end;
 * Interval(int a, int b){
 * this.start = a;
 * this.end = b;
 * }
 * }
 * <p>
 * 举例：
 * 输入：[1,5][10,15][5,10][20,30]
 * 输出：3
 * <p>
 * 考察：对复杂数据结构排序的能力
 * author: gubing.gb
 * date: 2017/2/12.
 */
public class A6OverLappingIntervalCount {
    public static void main(String[] args) {
        Interval[] arr = new Interval[]{new Interval(1, 5), new Interval(10, 15), new Interval(5, 10), new Interval(20, 30)};
        System.out.println(getOverLappingCount(arr));
    }

    static int getOverLappingCount(Interval[] arr) {
        int max = 0, count = 1;
        if (arr == null || arr.length == 0) return max;
        Point[] points = new Point[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {//转化为可排序的点
            points[2 * i] = new Point(arr[i].start, 0);
            points[2 * i + 1] = new Point(arr[i].end, 1);
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            if (points[i].type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }

    static class Interval {
        int start;
        int end;

        Interval(int a, int b) {
            this.start = a;
            this.end = b;
        }
    }

    static class Point implements Comparable<Point> {
        int value; //数值
        int type; //点的类型，0为起点，1为终点

        Point(int v, int t) {
            this.value = v;
            this.type = t;
        }

        //排序规则里没写type，是有默认规则吗？没有，所以示例代码是错的，下边相等时，添加tyep比较规则
        @Override
        public int compareTo(Point p) {
            if (this.value == p.value) {
                if (this.type > p.type) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.value > p.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

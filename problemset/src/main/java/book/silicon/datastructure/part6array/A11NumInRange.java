package book.silicon.datastructure.part6array;

import java.util.Arrays;
import java.util.Random;

/**
 * description: 给一个整形数组以及最大值和最小值，写函数产生一个随机数在max与min之间且不存在与整形数组中
 * 假设总能找到该随机数
 * 生成之后做检查，复杂度为O(n2)，太慢，考虑优化效率
 * 优化只能在查找时做，如果判重使用二分查找，可以优化到O(nlgn)
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class A11NumInRange {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int min = 0;
        int max = 10;
        System.out.println(numInRange(arr, max, min));
    }

    private static int numInRange(int[] arr, int max, int min) {
        Arrays.sort(arr);
        Random random = new Random();
        int range = max - min + 1;
        int num = random.nextInt(range) + min;

        while (Arrays.binarySearch(arr, num) >= 0) {
            num = random.nextInt(range) + min;
        }

        return num;
    }
}

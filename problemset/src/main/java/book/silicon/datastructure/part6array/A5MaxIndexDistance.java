package book.silicon.datastructure.part6array;

/**
 * description:
 * 1. 一个数组，找出最大下标距离j-i， 当且仅当A[i]<A[j]和i<j
 * tips：利用原数组的规律
 * <p>
 * 方案1：对每个元素找出其后比它大的元素，计算下标差值，取最大的，时间复杂度为O(n2)\  一般想法：一般都不是最优的，利用题目本身的特性优化
 * 方案2：根据元素排列规律，减少比较（参考KMP），最简单的是第一个是多长K，后面K个元素就不用比较了
 * 继续引申，查找更深层的关系
 * 例：{5,3,4,0,1,4,1}
 * 我们只需要记录从第一个元素开始的下降序列即可，即5,3,0（思考一下为什么第一个4没有用）
 * <p>
 * 2. 题目本身的特点，本题：下降序列O(3n)
 * author: gubing.gb
 * date: 2017/2/12.
 */
public class A5MaxIndexDistance {
    static int maxIndexDistance(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        boolean[] descSeq = new boolean[arr.length];

        //下降序列标记O(n)
        int min = arr[0], n = arr.length;
        descSeq[0] = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                descSeq[i] = true;
                min = arr[i];
            }
        }

        int maxDist = 0, i = n - 1, j = n - 1;
        while (i >= 0) {
            //找出下一个下降序列元素O(n)
            if (descSeq[i] == false) {
                i--;
                continue;
            }
            //找出符合元素O(n)
            while (arr[j] <= arr[i] && j > i) {
                j--;
            }
            if (j - i > maxDist) {
                maxDist = j - i;
            }
            i--;
        }

        return maxDist;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 0, 2, 4, 2};
        System.out.println(maxIndexDistance(arr));

    }
}

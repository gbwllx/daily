package book.silicon.datastructure.part6array;

/**
 * description:
 * 给定N（偶数）个整数，是否能找到N/2对，每对和都被K整除。配对中每个元素只能出现一次
 * 思考过程：
 * (a+b)%K=0 ====> a%K=z,b%K=K-z
 * 把这题转换成余数和的问题
 * <p>
 * <p>
 * author: gubing.gb
 * date: 2017/3/24.
 */
public class A9CheckPairable {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 9};
        int k = 3;
        System.out.println(checkPairable(arr, k));
    }

    //given solution比我的麻烦，yeh，hah
    private static boolean checkPairable(int[] arr, int k) {
        if (arr.length == 0 || k < 1) {
            return false;
        }
        int[] flag = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] % k;
            flag[key]++;
        }

        int pairCount = flag[0] / 2;
        for (int i = 1; i < k / 2 + 1; i++) {
            if (flag[i] > 0 && flag[k - i - 1] > 0) {
                pairCount += Math.min(flag[i], flag[k - i]);
            }
            if (pairCount >= arr.length / 2) return true;
        }
        return false;
    }
}

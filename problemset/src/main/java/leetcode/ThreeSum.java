package leetcode;

import leetcode.Utils.PrintUtils;

import java.util.*;

/**
 * @description: Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author: gubing.gb
 * @date: 2016/12/29.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{0, 4, 3, 0};
        //int target = 0;
        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        PrintUtils.printList(result);
    }

    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int[] temp = Arrays.copyOfRange(nums, i + 1, nums.length);
            List<List<Integer>> twoResult = twoSum(temp, 0 - nums[i]);
            for (List<Integer> list : twoResult) {
                list.add(0, nums[i]);
                result.add(list);
            }
        }

        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int dest) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(dest - nums[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(dest - nums[i]);
                list.add(nums[i]);
                result.add(list);
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }
}


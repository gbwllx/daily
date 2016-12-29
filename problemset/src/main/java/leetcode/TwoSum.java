package leetcode;

import leetcode.Utils.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
无序@muming
You may assume that each input would have exactly one solution.
有且只有一个（重复问题，多个问题，没有问题）@muming

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class TwoSum {

    public static void main(String[] args) {
        //int[] nums = new int[]{2, 7, 11, 15};
        //int[] nums = new int[]{20, 6, 5, 3, 30};
        //int target = 9;
        //上面的测试用例没有考虑到重复，以为有且只有一个就没有重复问题了，too young
        //看下面的测试用例，所以不能用hashMap重排，或者再扫一遍
        int[] nums = new int[]{0, 4, 3, 0};
        int target = 0;

        int[] result = new TwoSum().twoSum2(nums, target);
        PrintUtils.printArray(result);
    }


    //O(n)最佳算法，首次想法和最佳算法差距甚远啊，首次想法太直接了，继续努力，很多trick都忘记了
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            //get trick1
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    //首次想法O(3n)
    public int[] twoSum(int[] nums, int target) {
        int[] dest = new int[nums.length];
        System.arraycopy(nums, 0, dest, 0, nums.length);
        //O(lgn)
        Arrays.sort(nums);
        int head = 0;
        int tail = nums.length - 1;

        //O(3n)，使用hashmap可以优化到O(2n),不一定快
        while (head < tail) {
            int temp = nums[head] + nums[tail];
            if (temp == target) {
                int i = 0;
                int j = 0;
                for (; i < dest.length; i++) {
                    if (dest[i] == nums[head]) {
                        break;
                    }
                }
                for (; j < dest.length; j++) {
                    if (dest[j] == nums[tail] && j != i) {
                        break;
                    }
                }
                //还有返回结果的顺序问题
                return new int[]{i, j};
            } else if (temp < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }

}

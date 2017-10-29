package leetcode.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gubing.gb
 * @date: 2016/12/29.
 */
public class PrintUtils {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printList(List<List<Integer>> list) {
        System.out.println("[");
        for (List<Integer> outer : list) {
            System.out.print("[");
            for (Integer inner : outer) {
                System.out.print(inner + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}

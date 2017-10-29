package book.silicon.datastructure.part8tree;

import java.util.ArrayList;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C49MaxPathSum {
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> maxSum = new ArrayList<>(1);
        maxSum.add(Integer.MIN_VALUE);
        getMaxSum(root, maxSum);
        return maxSum.get(0);
    }

    private int getMaxSum(TreeNode root, ArrayList<Integer> maxSum) {
        if (root == null) {return 0;}
        int leftSum = 0, rightSum = 0;
        leftSum = getMaxSum(root.getLeft(), maxSum);
        rightSum = getMaxSum(root.getRight(), maxSum);
        int curSum = Math.max(root.getVal(), Math.max(root.getVal() + leftSum, root.getVal() + rightSum));
        maxSum.set(0, Math.max(maxSum.get(0), Math.max(curSum, root.getVal()) + leftSum + rightSum));
        return curSum;
    }
}

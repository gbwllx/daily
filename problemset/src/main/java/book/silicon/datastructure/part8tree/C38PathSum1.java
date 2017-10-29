package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C38PathSum1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null && root.getVal() == sum) {
            return true;
        } else {
            return hasPathSum(root.getLeft(), sum - root.getVal()) ||
                hasPathSum(root.getRight(), sum - root.getVal());
        }
    }
}

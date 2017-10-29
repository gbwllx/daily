package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C40BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return (getHeight(root) != -1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {return 0;}
        int leftHeight = getHeight(root.getLeft());
        if (leftHeight == -1) {return -1;}
        int rightHeight = getHeight(root.getRight());
        if (rightHeight == -1) {return -1;}
        if (Math.abs(leftHeight - rightHeight) > 1) {return -1;}
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

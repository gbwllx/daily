package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C43ClosestBST {
    TreeNode findClosestBST(TreeNode root, int val) {
        if (root == null) { return null;}
        if (root.getVal() == val) {return root;}
        TreeNode left = findClosestBST(root.getLeft(), val);
        TreeNode right = findClosestBST(root.getRight(), val);
        int diffLeft = left == null ? Integer.MAX_VALUE : Math.abs(val - left.getVal());
        int diffRight = right == null ? Integer.MAX_VALUE : Math.abs(val - right.getVal());
        int diff = Math.abs(val - root.getVal());
        int min = Math.min(diff, Math.min(diffLeft, diffRight));
        if (min == diff) {return root;} else if (min == diffLeft) {return left;} else {return right;}
    }
}

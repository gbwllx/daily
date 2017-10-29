package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C36LCA3 {
    TreeNode LCA3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {return null;}
        if (root == p || root == q) {return root;}
        TreeNode left = LCA3(root.getLeft(), p, q);
        TreeNode right = LCA3(root.getRight(), p, q);
        //p 和 q 分别在两边，则返回当前节点
        if (left != null && right != null) {return root;}
        return left == null ? right : left;

    }
}

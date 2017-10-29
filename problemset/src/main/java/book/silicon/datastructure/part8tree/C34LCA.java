package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C34LCA {
    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {return null;}
        if (root.getVal() > p.getVal() && root.getVal() > q.getVal()) {
            return LCA(root.getLeft(), p, q);
        } else if (root.getVal() < p.getVal() && root.getVal() < q.getVal()) {
            return LCA(root.getRight(), p, q);
        } else {
            return root;
        }
    }
}

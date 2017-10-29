package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C47RecoverTree {
    public void recoverTree(TreeNode root) {
        TreeNode n1 = null, n2 = null, prev = null;
        recoverTree(root, n1, n2, prev);
        if (n1 != null && n2 != null) {
            int tmp = n2.getVal();
            n2.setVal(n1.getVal());
            n1.setVal(tmp);
        }
    }

    private void recoverTree(TreeNode root, TreeNode n1, TreeNode n2, TreeNode prev) {
        if (root == null) {return;}
        recoverTree(root.getLeft(), n1, n2, prev);
        if (prev != null && prev.getVal() > root.getVal()) {
            n2 = root;
            if (n1 == null) {n1 = prev;}
        }
        prev = root;
        recoverTree(root.getRight(), n1, n2, prev);
    }
}

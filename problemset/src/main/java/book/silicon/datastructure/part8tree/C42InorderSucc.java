package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description: 带父节点，没写完
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C42InorderSucc {
    public TreeNode inorderSucc(TreeNode e) {
        if (e == null) {return null;}
        if (e.getRight() != null) {
            return getLeftMost(e.getRight());
        } else {
            //TreeNode p = e.parent;
        }
        return null;
    }

    private TreeNode getLeftMost(TreeNode right) {
        TreeNode res = right;
        while (res.getLeft() != null) {res = res.getLeft();}
        return res;
    }
}

package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/24.
 */
public class C33TreeToDoublyList {
    public void treeToDoublyList(TreeNode p, TreeNode prev, TreeNode head) {
        if (p == null) {return;}
        treeToDoublyList(p.getLeft(), prev, head);
        p.setLeft(prev);
        if (prev != null) {
            prev.setRight(p);
        } else {
            head = p;
        }
        TreeNode right = p.getRight();
        head.setLeft(p);
        p.setRight(head);
        prev = p;
        treeToDoublyList(right, prev, head);
    }
}

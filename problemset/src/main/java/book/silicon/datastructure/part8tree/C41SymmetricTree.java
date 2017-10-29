package book.silicon.datastructure.part8tree;

import java.util.LinkedList;
import java.util.Queue;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C41SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {return true;}
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.add(root.getLeft());
        right.add(root.getRight());
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (l == null && r == null) {continue;}
            if (l == null || r == null) {return false;}
            if (l.getVal() != r.getVal()) {return false;}
            left.add(l.getLeft());
            left.add(l.getRight());
            right.add(r.getRight());
            right.add(r.getLeft());
        }
        if (left.isEmpty() && right.isEmpty()) {return true;} else {return false;}
    }
}

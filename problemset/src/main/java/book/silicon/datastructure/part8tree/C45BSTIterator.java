package book.silicon.datastructure.part8tree;

import java.util.Iterator;
import java.util.Stack;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C45BSTIterator implements Iterator<Integer> {
    private Stack<TreeNode> stack = new Stack<>();

    C45BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode x = stack.pop();
        pushLeft(x.getRight());
        return x.getVal();
    }

}

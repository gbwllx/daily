package book.silicon.datastructure.part8tree;

import java.util.ArrayList;
import java.util.LinkedList;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C48ZigzagTree {
    public ArrayList<ArrayList<Integer>> zigzaglevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {return res;}
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        boolean leftToRight = true;
        while (curLevel.size() > 0) {
            ArrayList<Integer> curList = new ArrayList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while (curLevel.size() > 0) {
                TreeNode node = curLevel.poll();
                if (node.getLeft() != null) {nextLevel.add(node.getLeft());}
                if (node.getRight() != null) {nextLevel.add(node.getRight());}
                if (leftToRight) {
                    curList.add(node.getVal());
                } else {
                    curList.add(0, node.getVal());
                }
            }
            res.add(curList);
            curLevel = nextLevel;
            leftToRight = !leftToRight;
        }
        return res;
    }
}

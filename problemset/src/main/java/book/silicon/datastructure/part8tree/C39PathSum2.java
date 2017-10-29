package book.silicon.datastructure.part8tree;

import java.util.ArrayList;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C39PathSum2 {
    public void findPathSum2(TreeNode root, int sum) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findPathSumHelper(root, sum, path, res, 0);
    }

    private void findPathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res,
                                   int level) {
        if (root == null) {return;}
        path.add(root.getVal());
        if (root.getLeft() == null && root.getRight() == null) {
            int tmp = root.getVal();
            for (int i = level; i > -1; i--) {
                tmp -= path.get(i);
                if (tmp == 0) {copyList(path, i, level, res);}
            }
        } else {
            findSum(root.getLeft(), sum, path, level + 1);
            findSum(root.getRight(), sum, path, level + 1);
        }
        path.remove(path.size() - 1);
    }

    private void findSum(TreeNode right, int sum, ArrayList<Integer> path, int i) {
    }

    private void copyList(ArrayList<Integer> path, int from, int end, ArrayList<ArrayList<Integer>> res) {
        ArrayList<Integer> subPath = new ArrayList<>();
        for (int i = from; i <= end; i++) {
            subPath.add(path.get(i));
        }
        res.add(subPath);
    }
}

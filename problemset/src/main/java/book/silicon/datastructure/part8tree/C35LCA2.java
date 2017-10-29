package book.silicon.datastructure.part8tree;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description: 有指向父节点
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C35LCA2 {
    /**
     * 不写了
     **/

    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {return null;}
        TreeNode pq = new TreeNode(0);
        help(root, p, q, pq);
        TreeNode pp = pq.getLeft(), qq = pq.getRight();
        if (pp == null || qq == null) { return null;}
        int lenp = 0, lenq = 0;
        TreeNode up1 = pp, up2 = qq;
        //计算各种到顶的长度
        //while(up1 != root) {up1 = up1.getParent; lenp++;}
        return null;
    }

    private void help(TreeNode root, TreeNode p, TreeNode q, TreeNode pq) {
    }

}

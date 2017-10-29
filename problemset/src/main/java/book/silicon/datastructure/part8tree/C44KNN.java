package book.silicon.datastructure.part8tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import book.silicon.datastructure.part8tree.helper.TreeNode;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/25.
 */
public class C44KNN {
    public void findKNN(TreeNode root, int k, int target) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int abs1 = Math.abs(a);
                int abs2 = Math.abs(b);
                if (abs2 > abs1) {return 1;} else if (abs2 < abs1) {return -1;} else {return 0;}
            }
        };
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, comparator);
        findKNN(root, k, target, heap);
        Iterator<Integer> it = heap.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + target);
        }
    }

    private void findKNN(TreeNode root, int k, int target, PriorityQueue<Integer> heap) {
        if (root == null) {return;}
        findKNN(root.getLeft(), k, target, heap);
        if (heap.size() < k) {heap.add(root.getVal() - target);} else {
            int diff = Math.abs(root.getVal() - target);
            int maxdiff = Math.abs(heap.peek());
            if (maxdiff > diff) {
                heap.poll();
                heap.add(root.getVal() - target);
            }
        }
        findKNN(root.getRight(), k, target, heap);
    }
}

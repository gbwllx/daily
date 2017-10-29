package book.silicon.datastructure.part6array;

import java.util.ArrayList;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/23.
 */
public class A25SpiralOrder {
    ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) { return result; }
        int beginX = 0, endX = matrix[0].length - 1;
        int beginY = 0, endY = matrix.length - 1;

        while (true) {
            //外围从左到右
            for (int i = beginX; i <= endX; ++i) {
                result.add(matrix[beginY][i]);
            }
            //判断是否越界
            if (++beginY > endY) {break;}
            //从上到下
            for (int i = beginY; i <= endY; ++i) {
                result.add(matrix[i][endX]);
            }
            //判断是否越界
            if (beginX > --endX) {break;}
            //从右到左
            for (int i = endX; i >= beginX; --i) {
                result.add(matrix[endY][i]);
            }
            if (beginY > --endY) {break;}
            //从下到上
            for (int i = endY; i >= beginY; --i) {
                result.add(matrix[i][beginX]);
            }
            if (++beginX > endX) {break;}
        }
        return result;
    }
}

package cxx.note.fighting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test2 {
    public static final Integer i = new Integer(125);
    public Integer j = 125;

    public static void main(java.lang.String[] args) {
        int[][] matri = new int[3][3];
        matri[0] = new int[]{1,2,3};
        matri[1] = new int[]{4,5,6};
        matri[2] = new int[]{7,8,9};
        Solution solution = new Solution();
        matri = solution.rotate(matri);
        System.out.println(Arrays.deepToString(matri));
    }


}


class Solution {
    public int[][] rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] res = new int[rows][cols];
        int row = 0;
        for(int i = 0; i < rows; ++i) {
            row = cols - 1 - i;
            for(int j = 0; j < cols; ++j) {
                res[j][row] = matrix[i][j];
            }
        }
        return res;
    }
}

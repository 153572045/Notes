package cxx.code;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Temp {


    public static void main(String[] args) {
        int[][] exm = new int[4][4];
        exm[0] = new int[] {0, 1, 1, 0};
        exm[1] = new int[] {0, 1, 1, 0};
        exm[2] = new int[] {0, 0, 0, 0};
        exm[3] = new int[] {0, 1, 1, 0};
        System.out.print(max(exm));
    }

    static int max(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] area = new int[rows][cols];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j <cols; ++j) {
                if(matrix[i][j] == 1) {
                    if(i == 0 || j == 0) {
                        area[i][j] = 1;
                    } else {
                        area[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j],matrix[i][j -1]),matrix[i - 1][j - 1]);
                    }
                    if(area[i][j] > max) {
                        max = area[i][j];
                    }
                }
            }
        }
        return max * max;
    }




}
















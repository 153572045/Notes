package cxx.note;

import cxx.note.algorithm.sort.QuickSort;
import cxx.note.algorithm.sort.SortAge;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public static final String b = "abc";

    public static void main(String[] args) throws Exception{
        HashMap<String, String> map = new HashMap<>(16);
        Class clazz = map.getClass();
        Field threshod = clazz.getDeclaredField("threshold");
        threshod.setAccessible(true);
        Method capaticy = clazz.getDeclaredMethod("capacity");
        capaticy.setAccessible(true);
        System.out.println("初始容量：" + capaticy.invoke(map) + "初始阈值：" + threshod.get(map) + "元素数量：" + map.size());
        map.put("abc", "abc");
        System.out.println("初始容量：" + capaticy.invoke(map) + "初始阈值：" + threshod.get(map) + "元素数量：" + map.size());

    }

}

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] a = new int[rows * cols];
        col(matrix, a, cols, rows, 0, 0);
        return a;
    }

    private void col(int[][] matrix, int[] result, int cols, int rows, int tag, int index) {
        if(cols <= 0 || rows <= 0) {
            return ;
        }
        boolean ju = false;
        int temp = tag;
        for(int i = 0; i < cols; ++i) {
            result[index++] = matrix[tag][temp++];
        }
        temp--;
        int temp1 = tag + 1;
        for(int i = 0; i < rows - 1; ++i) {
            result[index++] = matrix[temp1++][temp];
            ju = true;
        }
        temp1 = temp1 - 1;
        for(int i = 0; i < cols - 1; ++i) {
            if(ju == false) {
                break;
            }
            result[index++] = matrix[temp1][--temp];
        }
        for(int i = 0; i < rows - 2; ++i) {
            result[index++] = matrix[--temp1][temp];
        }
        col(matrix, result, cols - 2, rows - 2, tag + 1, index);

    }
}

class FTEST {
    public static int count = 1;
    public static void test1() {
        count++;
        test1();
    }
}


/**
 * 插入排序
 */
class InsertSort {

    public int[] sort(int[] list) {
        int length = list.length;
        if (length <= 1) {
            return list;
        }
        for(int i = 1; i < length; i++) {
            int temp = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > temp) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
        return list;
    }
}

/**
 * 冒泡排序
 */
class BubbleSort {
    public int[] sort(int[] list) {
        int length = list.length;
        if (length <= 1) {
            return list;
        }
        for (int i = length - 1; i > 0; i--) {
            for(int j = 0; j < i; ++j) {
                if(list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }
}


class FindData {
    public int binarySearch(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        if(right == -1) {
            return 0;
        }
        while(left <= right) {
            mid = (left + right) / 2;
            if(arr[mid] == data) {
                return mid;
            }
            else if(arr[mid] < data) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * 递归
 */
class Recursion {
    public int sum(int n) {
        if(n == 1) {
            return n;
        }
        return n + sum(n - 1);
    }
}
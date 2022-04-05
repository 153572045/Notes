package cxx.note;

import cxx.note.algorithm.sort.QuickSort;
import cxx.note.algorithm.sort.SortAge;

import java.util.Arrays;

public class Test {

    public static final String b = "abc";

    public static void main(String[] args) throws Exception{
        System.out.println(Math.pow(2,4));

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
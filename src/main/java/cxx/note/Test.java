package cxx.note;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception{
        InsertSort insertSort = new InsertSort();
        BubbleSort bubbleSort = new BubbleSort();
        int[] test = new int[]{5,2,14,6,9,63,88,43,14};
        int[] result = bubbleSort.sort(test);
        System.out.println(Arrays.toString(result));
    }

}

/**
 * 快排
 */
class QuickSort {

    public int[] sort(int[] list, int left, int right) {
        if (left < right) {
            int pivot = partition(list, left, right);
            sort(list, left, pivot - 1);
            sort(list, pivot + 1, right);
        }
        return list;
    }

    private int partition(int[] list, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for(int i = index; i <= right; ++i) {
            if(list[i] < list[left]) {
                swamp(list, index, i);
                index++;
            }
        }
        swamp(list,index - 1, pivot);
        return index - 1;
    }

    private void swamp(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
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
package cxx.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test2 {

    public static void main(String[] args) {
        int[] a = {8,11,6,3,45,2,1};
        HeapSort quickSort = new HeapSort();
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class HeapSort {

    void sort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        buildHeap(arr);
        int len = arr.length;
        for(int i = len - 1; i > 0; --i) {
            swap(arr, 0, i);
            len--;
            heapSwap(arr,0, len);
        }
    }

    void buildHeap(int[] arr) {
        int len = arr.length;
        for(int i = len / 2 - 1; i >= 0; --i) {
            heapSwap(arr, i, len);
        }
    }

    void heapSwap(int[] arr, int p, int len) {
        if(p >= len - 1) {
            return ;
        }
        int left = p * 2 + 1;
        int right = left + 1;
        int maxId = p;
        if(left < len && arr[left] > arr[maxId]) {
            maxId = left;
        }
        if(right < len && arr[right] > arr[maxId]) {
            maxId = right;
        }
        if(maxId != p) {
            swap(arr, maxId, p);
            heapSwap(arr, maxId, len);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class QuickSort {

    void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    void quicksort(int[] arr, int left, int right) {
        if(left < right) {
            int index = position(arr, left, right);
            quicksort(arr, left, index - 1);
            quicksort(arr, index + 1, right);
        }
    }

    int position(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i <= right; ++i) {
            if(arr[pivot] > arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index-1, pivot);
        return index - 1;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


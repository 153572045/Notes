package cxx.note.algorithm.sort;

public class QuickSort {

    public int[] sort(int[] arr, int left, int right) {
        if(left < right) {
            int pivort = partition(arr, left, right);
            sort(arr, left, pivort - 1);
            sort(arr, pivort + 1, right);
        }
        return arr;
    }

    //思路： index下标及其右侧均大于或等于基准数
    private int partition(int[] arr, int left, int right) {
        int privot = left;
        int index = privot + 1;
        for(int i = index; i <= right; ++i) {
            if(arr[privot] > arr[i]) {
                swamp(arr, index, i);
                ++index;
            }
        }
        swamp(arr, index - 1, privot);
        return index - 1;
    }




    private void swamp(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

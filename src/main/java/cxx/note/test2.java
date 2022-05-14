package cxx.note;


public class test2 {
    public static void main(String[] args) throws Exception {
        Pair<Manage> mana = new Pair<>(new Manage(), new Manage());
        Pair<employee> employeePair = new Pair<>(new employee(), new employee());
    }
}

class Pair<T> {
    private T first;
    private T second;
    Pair(T F, T S) {
        first = F;
        second = S;
    }
    T getFirst() {
        return first;
    }
    void setFirst(T first) {
        this.first = first;
    }
}

class employee {

}

class Manage extends employee {

}



class ArrayAlg
{
    public static <T> T getMiddle(T... a)
    {
        for(int i = 0; i < a.length; ++i) {
            System.out.println(a[i].toString());
        }
        return null;
    }
}

class atest {

}

class Solution1 extends HeapSort{
    public int[] exchange(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int head = 0;
        int tail = nums.length - 1;
        while(head != tail) {
            while(tail > head && nums[tail] % 2 == 0) {
                tail--;
            }
            if(nums[head] % 2 != 1) {
                swap(nums, head, tail);
                head++;
            } else {
                head++;
            }
        }
        return nums;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
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


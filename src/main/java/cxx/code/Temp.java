package cxx.code;


import java.lang.management.ThreadMXBean;
import java.lang.ref.WeakReference;

public class Temp {


    public static void main(String[] args) throws Exception {
        Integer a = 12312;


        System.out.println(myPow(3, 6));
    }
    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        boolean abs = n > 0 ? false : true;
        if(abs) {
            n = -n;
        }
        double res = recur(x, n);
        if(abs) {
            res = 1 / res;
        }
        return res;
    }

    static double recur(double x, int n) {
        if(n == 1) {
            return x;
        }
        double res = recur(x, n / 2);
        res = res * res;
        if(n % 2 == 1) {
            res = res * x;
        }
        return res;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
        return arr;
    }

    static int partition(int[] arr, int left, int right) {
        int pivort = left;
        int index = pivort + 1;
        for(int i = index; i <= right; ++i) {
            if(arr[i] < arr[pivort]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivort, index - 1);
        return index - 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}


class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public void printAll() {
        ListNode temp = null;
        System.out.println(val);
        temp = next;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}















package cxx.note;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class test2 {
    static Map<String, Long> map = new HashMap<>();
    public static void main(java.lang.String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        Map map = new HashMap();
    }

    static int[] gaotu(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int point1 = 0;
        int point2 = len2 - 1;
        while(arr1[point1] != 0) {
            point1++;
        }
        point1 = point1 - 1;
        int point3 = len1 - 1;
        while(point3 >= 0 && point1 >= 0 && point2 >= 0) {
            if(arr1[point1] > arr2[point2]) {
                arr1[point3--] = arr1[point1--];
            } else {
                arr1[point3--] = arr2[point2--];
            }
        }
        if(point1 < 0) {
            while(point3 >= 0) {
                arr1[point3--] = arr2[point2--];
            }
        } else {
            while(point3 >= 0) {
                arr1[point3--] = arr1[point1--];
            }
        }
        return arr1;
    }
}

class BigHeap {

    int[] sort(int[] arr) {
        int len = arr.length;
        arr = buildHeap(arr, len);
        for(int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapSwap(arr, 0, --len);
        }
        return arr;
    }

    int[] buildHeap(int[] arr, int len) {
        for(int i = len / 2 - 1; i >= 0; i--) {
            heapSwap(arr, i, len);
        }
        return arr;
    }

    void heapSwap(int[] arr, int p, int len) {
        if(p >= len) {
            return ;
        }
        int maxid = p;
        int left = p * 2 + 1;
        int right = left + 1;
        if(left < len && arr[left] > arr[maxid]) {
            maxid = left;
        }
        if(right < len && arr[right] > arr[maxid]) {
            maxid = right;
        }
        if(maxid != p) {
            swap(arr, maxid, p);
            heapSwap(arr, maxid, len);
        }
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}



class MyClassLoader extends ClassLoader {
    private java.lang.String byteCodePath;

    public MyClassLoader(java.lang.String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader(ClassLoader parent, java.lang.String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(java.lang.String name) throws ClassNotFoundException {
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            //获取字节码文件的完整路径
//            java.lang.String fileName = byteCodePath + name + ".class";
            java.lang.String fileName = byteCodePath + name;
            //获取一个输入流
            bis = new BufferedInputStream(new FileInputStream(fileName));
            //获取一个输出流
            baos = new ByteArrayOutputStream();
            //具体读入数据写出的过程
            int len;
            byte[] data = new byte[1024];
            while ((len = bis.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            //获取内存中完整的字节数组的数据
            byte[] byteCodes = baos.toByteArray();
            //调用defineClass(),将字节数组的数据转换为Class的实例
            Class<?> clazz = defineClass(null, byteCodes, 0, byteCodes.length);
            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

class Solution11 {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int temp = 0;
        for(int i = 0; i < nums.length; ++i) {
            while(nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }
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


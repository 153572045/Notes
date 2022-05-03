package cxx.note;

import cxx.note.algorithm.sort.QuickSort;
import cxx.note.algorithm.sort.SortAge;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class Test1 {

    private static final String ADDRESS = "192.168.80.129:2181";
    private static final String PATH = "/child";
    private static final RetryPolicy retryPolicy = new ExponentialBackoffRetry(2000, 30000);


    public static void main(String[] args) throws Exception {

    }


    @Test
    void testGetReadLock3() throws Exception {
        InterProcessReadWriteLock interProcessReadWriteLock = new InterProcessReadWriteLock(getZkClient(), "/lock1");
        InterProcessLock interProcessLock = interProcessReadWriteLock.readLock();
        System.out.println("等待获取读锁对象！");

        interProcessLock.acquire();
        for(int i = 1; i <=100; i++) {
            Thread.sleep(3000);
            System.out.println(i);
        }
        interProcessLock.release();
        System.out.println("等待释放锁");
    }

    @Test
    void testGetWriteLock() throws Exception {
        InterProcessReadWriteLock interProcessReadWriteLock = new InterProcessReadWriteLock(getZkClient(), "/lock1");
        InterProcessLock interProcessLock = interProcessReadWriteLock.writeLock();
        System.out.println("等待获取写锁对象！");

        interProcessLock.acquire();
        for(int i = 1; i <=100; i++) {
            Thread.sleep(3000);
            System.out.println(i);
        }
        interProcessLock.release();
        System.out.println("等待释放锁");
    }


    private static CuratorFramework getZkClient() {
        String zkServerAddress = "192.168.80.129:2181";
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3, 5000);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString(zkServerAddress)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();
        return zkClient;
}
}

class Solution32 {
    private int result = 0;
    public int maxValue(int[][] grid) {
        if(grid == null) {
            return 0;
        }
        dif(grid, 0, 0, 0);
        return result;
    }

    void dif(int[][] grid, int i, int j, int sum) {
        if(i >= grid.length || j >= grid[0].length) {
            return ;
        }
        sum+= grid[i][j];
        if(i == grid.length -1 && j == grid[0].length - 1) {
            if(sum > result) {
                result = sum;
            }
        }
        dif(grid, i + 1, j, sum);
        dif(grid, i, j + 1, sum);
    }
}

class Solution22 {
    public String lengthOfLongestSubstring(String s) {
        int index = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        int point = -1;
        int length = s.length();
        for(int i = 0; i < length; ++i) {
            if(i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while(point + 1 < length && !set.contains(s.charAt(point + 1))) {
                set.add(s.charAt(point + 1));
                point++;
            }
            if(result < set.size()) {
                result = set.size();
                index = i;
            }
        }
        String r = s.substring(index, index + result);
        return r;
    }
}

class Solu1 {
    TreeNode result;
    TreeNode target;
    boolean isT = false;
    public TreeNode levelOrder(TreeNode root) {
        if(root == null) {
            return null;
        }
        target = root;
        return null;
    }

    void cur(TreeNode  node) {
        if(node == null) {
            return ;
        }
        cur(node.left);

        cur(node.right);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
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

package cxx.note.summary.Thread.Demo;

public class demo1 {

    public static void main(String[] args) {
        try {
            int[] a = new int[2];
            a[5] = 5;
        } catch (Exception e) {
            System.out.println("outb");
        }
        System.out.println("结束");
    }
}

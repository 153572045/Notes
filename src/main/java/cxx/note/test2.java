package cxx.note;

import java.util.Arrays;

public class test2 {

    public static void main(String[] args) throws Exception {
        char[] a = new char[] {'1', '2', 'c'};
        char[] b = Arrays.copyOf(a, 6);
        b[3] = 0;
        System.out.println(Arrays.toString(b));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abc");
    }
}



package cxx.code.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        DynamicProxy inter = new DynamicProxy(new ArrayList<>());
//        List<String> list = (List<String>) inter.getProxy();
//        System.out.println(Arrays.toString(list.getClass().getAnnotatedInterfaces()));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
    }
}

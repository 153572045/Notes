package cxx.note;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    public static void main(String[] args) throws Exception{
        System.out.println("abc");
        Map<String, String> map = new HashMap<>();
        Thread.sleep(100);
        ExecutorService pool = Executors.newCachedThreadPool();
    }


    class ttt implements Serializable {

    }
}

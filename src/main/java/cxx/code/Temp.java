package cxx.code;


import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Temp {


    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();

        lock.unlock();
    }


}
















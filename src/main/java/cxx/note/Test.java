package cxx.note;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Test {

    public static void main(String[] args) throws Exception{
        Employee e1 = new Employee("chen", 28, 20000.0);
        Employee e2 = new Employee("hu", 25, 11000.0);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/java/cxx/note/testWrite.txt"));
        out.writeObject(e1);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/cxx/note/testWrite.txt"));
        Employee e3 = (Employee) in.readObject();
        System.out.println(e3);
    }


}

class Employee implements Serializable {
    String name;
    int age;
    double salary;
    Employee(String n, int a, double s) {
        name = n;
        age = a;
        salary = s;
    }

    private void writeObject(ObjectOutputStream out) throws Exception {
        out.defaultWriteObject();
        out.writeDouble(22);
    }

    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        double x = in.readDouble();
        salary += x;
    }

    @Override
    public String toString() {
        String result = "name:" + name + "|" + "age:" + age + "|" + "salary:" + salary;
        return result;
    }
}

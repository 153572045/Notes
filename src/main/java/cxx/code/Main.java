package cxx.code;


import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gson fullGson = (new GsonBuilder()).serializeNulls().create();
        Person person = new Person("chen", 30);
        Person person1 = new Person("hu", 27);
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        String str = fullGson.toJson(list);
        System.out.println(str);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        String ano = new String(bytes, Charsets.UTF_8);
        List<Person> lll = fullGson.fromJson(ano, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println(lll);

    }

}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "name : " + name + "age : " + age;
    }
}
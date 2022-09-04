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

    }
    public static char find(String s) {
        if(s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            if(map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < s.length(); ++i) {
            if(map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}


package cxx.note;

import java.net.Socket;
import java.util.*;

public class test2 {
        public static void main(String[] args) {
                Size size = Size.SMALL;
                System.out.println(size.getName());
                System.out.println(size.ordinal());
        }

}

enum Size
{
        SMALL("chen"),BIG("hu");
        private String name;
        Size(String name) {
                this.name = name;
        }
        String getName() {
                return name;
        }
}



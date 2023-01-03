package cxx.code;

public class Test22 {

    public static void main(String[] args) {
        Itest.pr();
    }
}

class TT implements Itest {

}
interface Itest {
    static void pr() {
        System.out.printf("abc");
    }
}

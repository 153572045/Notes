package cxx.note.fighting;

public class test2 {
    public static final Integer i = new Integer(125);
    public Integer j = 125;

    public static void main(java.lang.String[] args) {
        String a = new String();
        System.out.println(String.class.getClassLoader());
        System.out.println(java.lang.String.class.getClassLoader());
    }





}
class Tess {
    public void justTest() {
        int[] a = new int[3];
        try {
            a[5] = 2;
        } catch (Exception e) {
            System.out.println("error happen");
        }
        System.out.println("over");
    }
}

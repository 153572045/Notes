package cxx.note.summary.网络.demo;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("你说： ");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}

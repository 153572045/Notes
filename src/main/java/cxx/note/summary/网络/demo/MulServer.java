package cxx.note.summary.网络.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MulServer {
    /**
     * 目标:实现服务端可以同时接收多个客户端的Socket通信需求。
     * 思路：服务端每接收到一个客户端socket请求对象之后都交给一个独立的线程来处理客户端的数据交互需求
     * @param args
     */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("服务端已启动=====");
            while(true) {
                Socket socket = ss.accept();
                ServerHandler.process(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cxx.note.summary.网络.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：开发实现伪异步通信架构----线程池的方式实现
 */
public class PoolServer {


    public static void main(String[] args) {
        PoolHandler pool = new PoolHandler();
        pool.init(6,10);
        try {
            ServerSocket ss = new ServerSocket(9999);
            while(true) {
                Socket socket = ss.accept();
                pool.execute(() -> {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String msg;
                        while((msg = br.readLine()) != null) {
                            System.out.println(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

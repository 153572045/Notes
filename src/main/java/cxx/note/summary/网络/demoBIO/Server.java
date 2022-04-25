package cxx.note.summary.网络.demoBIO;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：服务端可以反复接收消息，客户端也可以反复发送信息
 */
public class Server {

    public static void main(String[] args) throws Exception{

        System.out.println("==服务端启动");
        ServerSocket ss = new ServerSocket(9999);  //这行代码执行完，客户端就能连接了，因此accept监听应该是程序监听操作系统，此时操作系统已经可以被连接
        Socket socket = ss.accept();            //此处注意，这个服务端只能处理一个客户端，如果有多个客户端打进来，第二个及之后的客户端将不会被处理，因为这个地方只执行一次
        InputStream is = socket.getInputStream();       //我理解如果有第二个客户端请求，也可以和服务端进行连接，只不过是服务端程序没有代码可以进行处理而已，操作系统还是会进行TCP连接
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg;
        while((msg = br.readLine()) != null) {
            System.out.println("服务端收到: " + msg);
            Thread.sleep(10000);
        }

    }
}

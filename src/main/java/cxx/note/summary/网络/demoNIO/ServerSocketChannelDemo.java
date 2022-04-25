package cxx.note.summary.网络.demoNIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ServerSocketChannelDemo {

    public static void main(String[] args) throws Exception{
        int port = 8888;

        ByteBuffer buf = ByteBuffer.wrap("hello nio".getBytes(StandardCharsets.UTF_8));
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定
        ssc.socket().bind(new InetSocketAddress(port));

        ssc.configureBlocking(false);

        while (true) {
            System.out.println("开始检测连接====");
            SocketChannel sc = ssc.accept();
            if(sc == null) {
                System.out.println("没有连接");
                Thread.sleep(2000);
            } else {
                System.out.println("来连接了 ：" + sc.socket().getRemoteSocketAddress());
                buf.rewind(); //指针指向0
                sc.write(buf);
                sc.close();
            }
        }
    }
}

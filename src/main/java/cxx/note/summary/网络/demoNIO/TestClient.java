package cxx.note.summary.网络.demoNIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestClient {

    private static int count = 0;

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));
        // 还有另一种创建方式 channel = SocketChannel.open(); channel.connet(InetSocketAddress);
        /*
        连接检验方法：
        socketChannel.isOpen();socketChannel.isConnected();socketChannel.inConnectionPending();是否正在进行连接
        socketChannel.finishConnect();是否已经完成连接
         */
        System.out.println(socketChannel.finishConnect());
        socketChannel.configureBlocking(true);

//        ByteBuffer buf = ByteBuffer.allocate(16);

//        socketChannel.read(buf);
//        socketChannel.close();
        System.out.println("读取完毕");
        Thread.sleep(10000);

        String msg = "Hello Server! i am client: " + ++count;
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        Thread.sleep(1000000);
    }
}

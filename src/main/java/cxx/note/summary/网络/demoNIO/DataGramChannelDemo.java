package cxx.note.summary.网络.demoNIO;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DataGramChannelDemo {

    @Test
    public void sendDatagram() throws Exception{
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 9999);

        //发送
        while(true) {
            ByteBuffer buf = ByteBuffer.wrap("我在发哈哈哈".getBytes(StandardCharsets.UTF_8));
            sendChannel.send(buf, sendAddress);
            System.out.println("东西已发");
            Thread.sleep(20000);
        }
    }

    @Test
    public void receiveDatagram() throws Exception{
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress receiveAddress = new InetSocketAddress(9999);
        //绑定
        receiveChannel.bind(receiveAddress);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(true) {
            buf.clear();
            SocketAddress address = receiveChannel.receive(buf);
            buf.flip();
            System.out.println(address.toString());
            System.out.println(Charset.forName("UTF-8").decode(buf));
        }
    }


}

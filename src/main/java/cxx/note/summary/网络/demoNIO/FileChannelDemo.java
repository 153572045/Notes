package cxx.note.summary.网络.demoNIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannelDemo {
    /**
     * FileChannel读取数据到buffer中
     * @param args
     */
    public static void main(String[] args) throws Exception{
        transfer();
    }
    //通道的读操作
    private static void channelRead() throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("D:\\Java项目\\Notes\\src\\main\\java\\cxx\\note\\summary\\网络\\demoNIO\\ioTest", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);  // buf == -1  表示读取结束,到文件末尾
        int byteRead = channel.read(buf);
        while (byteRead != -1) {
            System.out.println("读取了： " + byteRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char)buf.get());
            }
            buf.clear();
            byteRead = channel.read(buf);
        }
    }
    //通道的写操作
    private static void channelWrite() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\Java项目\\Notes\\src\\main\\java\\cxx\\note\\summary\\网络\\demoNIO\\ioTest", "rw");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String data = "data chen";
        buf.put(data.getBytes(StandardCharsets.UTF_8));
        buf.flip();
        System.out.println(buf.remaining());
        while (buf.hasRemaining()) {    //因为无法保证每次写进去多少数据，所以要循环调用
            channel.write(buf);
        }
    }

    //通道间的数据传输
    private static void transfer() throws Exception{
        RandomAccessFile tranFrom = new RandomAccessFile("D:\\Java项目\\Notes\\src\\main\\java\\cxx\\note\\summary\\网络\\demoNIO\\ioTest", "rw");
        FileChannel channel = tranFrom.getChannel();
        RandomAccessFile tranTo = new RandomAccessFile("D:\\Java项目\\Notes\\src\\main\\java\\cxx\\note\\summary\\网络\\demoNIO\\ioTestTo", "rw");
        FileChannel channel1 = tranTo.getChannel();
        long position = 0;
        channel1.transferFrom(channel, position, channel.size());
        channel.close();
        channel1.close();
        System.out.println("传输完成");
    }
}

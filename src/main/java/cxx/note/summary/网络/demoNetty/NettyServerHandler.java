package cxx.note.summary.网络.demoNetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/*
说明
我们自定义一个Handler需要实现netty规定好的某个HandlerAdapter(规范)
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /*
    该函数可以读取客户端发送的消息
    第一个参数ctx,即上下文对象，含有管道pipeline,通道channel,和客户端地址等信息
    msg:客户端发送的数据，默认是Object类型，实际类型应该是ByteBuf
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链表，出栈出栈


        ByteBuf buf = (ByteBuf) msg; //和NIO的ByteBuff不同，具有更高的效率
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
        System.out.println("客户端发送的消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //是write方法和flush方法的合并，将数据写入缓冲并刷到管道
        //一般会对数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端", CharsetUtil.UTF_8));
    }

    //处理异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

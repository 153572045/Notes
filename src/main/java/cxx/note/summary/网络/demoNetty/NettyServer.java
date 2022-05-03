package cxx.note.summary.网络.demoNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws Exception {

        //创建了两个线程组，bossGroup仅处理连接请求
        //真正和客户端业务处理会交给workerGroup去处理
        //在运行时这两者都处于无限循环中
        //bossGroup和workerGroup中含有的子线程(NIOEventLoop)的个数默认是cpu核数*2，也可以自己指定
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //默认8个线程，轮询处理客户端的请求，即从1到8，再从1到8

        try {
            //创建服务器端的启动对象，进行启动参数的配置

            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup)  //设置两个线程组
                    .channel(NioServerSocketChannel.class) //设置使用的通道类型,作为服务器通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道初始化对象(匿名对象)
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    }); //给workerGroup的EventLoop(线程)对应的管道(pipeline)设置处理器

            System.out.println("...服务器 is ready");

            //绑定一个端口并且同步，生成一个ChannelFuture对象  该方法会立即返回，后续再去拿cf的值
            //同时启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //对关闭通道进行监听,当有关闭通道的消息或事件的时候会进行关闭
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}

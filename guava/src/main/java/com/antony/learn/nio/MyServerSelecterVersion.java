/*
 * @projectName jyplatform
 * @package com.antony.learn.nio
 * @className com.antony.learn.nio.MyServerSelecterVersion
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

package com.antony.learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * MyServerSelecterVersion
 *
 * @author wangqian
 * @version TODO
 * @description TODO
 * @date 2018/9/10 16:56
 */
public class MyServerSelecterVersion {
    public static void main(String[] args) throws Exception {
        try {
            //打开选择器
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8090));
            serverSocketChannel.configureBlocking(false);
            //向通道注册选择器，并且注册接受事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                //获取已经准备好的通道数量
                int readyChannels = selector.selectNow();
                //如果没准备好，重试
                if (readyChannels == 0) {
                    continue;
                }
                //获取准备好的通道中的事件集合
                Set selectedKeys = selector.selectedKeys();
                Iterator keyIterator = selectedKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = (SelectionKey) keyIterator.next();
                    if (key.isAcceptable()) {
                        //在自己注册的事件中写业务逻辑，
                        //我这里注册的是accept事件，
                        //这部分逻辑和上面非选择器服务端代码一样。
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverSocketChannel1.accept();
                        ByteBuffer buf1 = ByteBuffer.allocate(1024);
                        socketChannel.read(buf1);
                        buf1.flip();
                        if (buf1.hasRemaining()) {
                            System.out.println(">>>服务端收到数据：" + new String(buf1.array()));
                        }
                        buf1.clear();

                        ByteBuffer header = ByteBuffer.allocate(6);
                        header.put("[head]".getBytes());
                        ByteBuffer body = ByteBuffer.allocate(1024);
                        body.put("i am body!".getBytes());
                        header.flip();
                        body.flip();
                        ByteBuffer[] bufferArray = {header, body};
                        socketChannel.write(bufferArray);

                        socketChannel.close();
                    } else if (key.isConnectable()) {
                    } else if (key.isReadable()) {
                    } else if (key.isWritable()) {

                    }
                    //注意每次迭代末尾的keyIterator.remove()调用。
                    //Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。
                    //下次该通道变成就绪时，Selector会再次将其放入已选择键集中
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

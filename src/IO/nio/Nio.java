package IO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 11:41
 * @description
 **/
public class Nio {
    public static void main(String[] args) throws IOException {
        int[] ports = new int[5];
        ports[0] = 8890;
        ports[1] = 8891;
        ports[2] = 8892;
        ports[3] = 8893;
        ports[4] = 8894;

        Selector selector = Selector.open();
        for(int i = 0 ; i < ports.length; i++) {
//           绑定
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            SocketAddress socketAddress = new InetSocketAddress(ports[i]);
            serverSocket.bind(socketAddress);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口：" + ports[i]);
        }

        while(true) {
            int num = selector.select();
            System.out.println("number:" + num);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println(selectionKeys.size());
            System.out.println("selectionKeys:" + selectionKeys);
            Iterator<SelectionKey> iterators = selectionKeys.iterator();
            while(iterators.hasNext()) {
                SelectionKey selectionKey = iterators.next();
                if(selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    iterators.remove();
                    System.out.printf("获得客户端连接：" + socketChannel);
                }
                else if(selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int byteRead = 0;
                    while(true) {
                        ByteBuffer buffer = ByteBuffer.allocate(512);
                        buffer.clear();
                        int reader = socketChannel.read(buffer);

                        if(reader < 0) {
                            break;
                        }
                        buffer.flip();
                        socketChannel.write(buffer);
                        byteRead += reader;
                    }
                    System.out.println("读取：" + byteRead + "，来自于：" + socketChannel);
                    iterators.remove();

                }
            }
        }
    }
}

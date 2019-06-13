package IO.nio;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 10:35
 * @description
 **/
public class NioScatterAndGathering {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(socketAddress);
        int message = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        while(true) {
            int byteRead = 0;
            while(byteRead < message) {
                long r = socketChannel.read(buffers);
                byteRead += r;
                System.out.println("byteread" + byteRead);
                Arrays.asList(buffers).stream()
                .map(buffer -> "position" + buffer.position() + "，limit" + buffer.limit()).forEach(System.out::println);
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.flip();
            });

            long writerByte = 0;
            while(writerByte < message) {
                long w = socketChannel.write(buffers);
                writerByte += w;
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });

            System.out.println("byteread" + byteRead + ", writeByte" + writerByte + ",message" + message );

        }

//scattering  and gathering 类似于netty中解决tcp粘包问题
    }
}

package IO.nio;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 15:49
 * @description
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {
        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(8899));
            while(true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for(SelectionKey selectionKey : selectionKeys) {
                    if(selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if(client.isConnectionPending()) {
                            client.finishConnect();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            buffer.put((LocalDateTime.now() + "连接成功@").getBytes());
                            buffer.flip();
                            client.write(buffer);
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                try{
                                    buffer.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                    String sendMessage = bufferedReader.readLine();
                                    buffer.put(sendMessage.getBytes());
                                    buffer.flip();
                                    client.write(buffer);
                                }catch(Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    }else if(selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int reader = client.read(byteBuffer);
                        if(reader > 0) {
                            String receivedMessage  = new String(byteBuffer.array() , 0, reader);
                            System.out.println(receivedMessage);

                        }
                    }
                }

//               代码最后一低昂要清除 selectionKey
                selectionKeys.clear();
            }

        }catch (Exception e) {

        }


    }
}

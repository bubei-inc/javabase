package IO.nio;

import apple.laf.JRSUIConstants;
import com.sun.javafx.image.ByteToBytePixelConverter;
import com.sun.org.apache.bcel.internal.generic.Select;
import sun.reflect.generics.scope.Scope;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 15:19
 * @description
 **/
public class NioSocketServer {
    private static Map<String,SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {


//        服务器端 需要保存channel才可以找到客户端的相关信息
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

//       创建selector方法
        Selector selector = Selector.open();serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

//        处理代码
        while(true) {
            try{
//                首先需要使用selecto.select()获取相关的阻塞
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();


                selectionKeySet.forEach(selectionKey -> {
                    final SocketChannel client;
                    try{
                        if(selectionKey.isAcceptable()) {
//                            客户端连接服务器端  serverSocketChannel 关注的市是连接这个事件
                            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                            client = serverSocketChannel1.accept();
//                            设置为非阻塞 socketChannel 关注的是读这个事件
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
//                            服务器端记录客户端的channel 数据
                            String key = "[" + UUID.randomUUID().toString()+ "]";
                            clientMap.put(key, client);
                        }else if(selectionKey.isReadable()) {
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(512);
                            buffer.clear();
                            int read = client.read(buffer);
                            if(read > 0)  {
                                buffer.flip();
                                Charset charset =  Charset.forName("utf-8");
                                String recivedMessge = String.valueOf(charset.decode(buffer).array());
                                System.out.println(client + "：信息：" + recivedMessge);
//                                分发到所有的客户端
                                String senderKey = null;
                                for(Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if(client == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }
                                for(Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                                    byteBuffer.put((senderKey + ":" + recivedMessge).getBytes());
                                    byteBuffer.flip();
                                    value.write(byteBuffer);
                                }
                            }
                        }
                    }catch (Exception e) {

                    }
                });

                selectionKeySet.clear();
            }catch (Exception e ) {

            }
        }

    }
}

package IO.nio;

import java.io.BufferedReader;
import java.nio.ByteBuffer;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 09:42
 * @description
 **/
public class NioTestCase4 {
    public static void main(String[] args) {
//        分片buffer
        ByteBuffer buffer = ByteBuffer.allocate(100);
        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(6);
        ByteBuffer sliceBuffer = buffer.slice();
        for(int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = buffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}

package IO.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-04 16:19
 * @description
 **/
public class NioTestCase2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/test.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        byte[] b = "hello world!".getBytes();
        for(int i = 0; i < b.length; i++) {
            buffer.put(b[i]);
        }
        buffer.flip();
        fileChannel.write(buffer);
        fileOutputStream.close();
    }
}

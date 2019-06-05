package IO.nio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-04 16:12
 * @description
 **/
public class NioTestCase1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/test.txt");

        FileChannel file = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        file.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println((char)b);
        }
        fileInputStream.close();
    }
}

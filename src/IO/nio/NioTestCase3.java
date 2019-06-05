package IO.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-04 17:22
 * @description
 **/
public class NioTestCase3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/output.txt");
        FileChannel fileInChannel = fileInputStream.getChannel();
        FileChannel fileOutChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true) {
            byteBuffer.clear();
            int read = fileInChannel.read(byteBuffer);
            if(-1 == read) {
                break;
            }
            byteBuffer.flip();
            fileOutChannel.write(byteBuffer);

        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}

package IO.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 10:05
 * @description
 **/
public class NioDirectBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/output.txt");
        FileChannel fileInChannel = fileInputStream.getChannel();
        FileChannel fileOutChannel = fileOutputStream.getChannel();
        //allocateDirect()
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
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

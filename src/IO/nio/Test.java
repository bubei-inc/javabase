package IO.nio;

import com.sun.org.apache.bcel.internal.generic.IFLE;
import com.sun.xml.internal.ws.spi.db.FieldSetter;
import sun.awt.FullScreenCapable;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-04 17:40
 * @description
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] b = "hello".getBytes();
        byteBuffer.put(b);

        FileInputStream fileInputStream = new FileInputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/james/IdeaProjects/ThreadTest/src/IO/output.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        FileChannel fileChannelOut = fileOutputStream.getChannel();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        //仅仅只是修改了flip中position limit还有mark的值，但是写进byteBuffer的数据还在
        fileChannelOut.write(byteBuffer);
        int read1 = fileChannel.read(byteBuffer);
        System.out.println(read);
        System.out.println(read1);

    }
}

package Codec;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author syp
 * @package_name Codec
 * @date 2019-06-05 16:37
 * @description
 **/
public class NioCodec {
    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/james/IdeaProjects/ThreadTest/src/Codec/input.txt";
        String outputFile = "/Users/james/IdeaProjects/ThreadTest/src/Codec/output.txt";
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");
        FileChannel fileChannelInput = inputRandomAccessFile.getChannel();
        long fileLength = new File(inputFile).length();
        FileChannel fileChannelOutput =  outputRandomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannelInput.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);

        Charset charset = Charset.forName("utf-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharBuffer charBuffer = charsetDecoder.decode(mappedByteBuffer);
        ByteBuffer buffer = charsetEncoder.encode(charBuffer);
        fileChannelOutput.write(buffer);
        inputRandomAccessFile.close();
        outputRandomAccessFile.close();




    }
}

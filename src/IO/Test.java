package IO;

import java.io.*;

public class Test {
    /*public static void main(String[] args) throws IOException {
        File inFile = new File("/Users/james/shell/test.txt");
        File outFile = new File("/Users/james/shell/text.txt");

        FileInputStream inputStream = new FileInputStream(inFile);
        FileOutputStream outputStream = new FileOutputStream(outFile);

        //读取inputStream中的数据存放到outPutStream 中
        byte[] content = new byte[1024];
        // 1. 边读边存
        int length;

        while((length = inputStream.read(content)) != -1 ) {
            outputStream.write(content,0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }*/


    public static void main(String[] args) throws IOException {
        File inFile = new File("/Users/james/shell/test.txt");
        File outFile = new File("/Users/james/shell/txt.txt");

        FileInputStream inputStream = new FileInputStream(inFile);
        FileOutputStream outputStream = new FileOutputStream(outFile);
        byte[] content = new byte[(int)inFile.length()];
        System.out.println(inFile.length());
        //将inputStream 中的字节存放到content中
        inputStream.read(content);
        for(byte c : content) {
            System.out.println((char) c);
        }
        outputStream.write(content);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
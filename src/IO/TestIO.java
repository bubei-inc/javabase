package IO;

import java.io.*;
import java.sql.SQLOutput;

public class TestIO {
    public static void main(String[] args) {
//        File file = new File("/Users/james/Desktop/test.txt");
//        try {
//           // FileInputStream fileInputStream= new FileInputStream(file);
//            String hello = new String("hello word@james");
//            byte[] bytes = hello.getBytes();
//            OutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);;
//            fileOutputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch(IOException e) {
//            e.printStackTrace();
//        }finally {
//        }

        try {
            File file = new File("/Users/james/Desktop/test.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            int content = fileInputStream.read();
            System.out.println("this is content of test.txt:" + (char)content);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

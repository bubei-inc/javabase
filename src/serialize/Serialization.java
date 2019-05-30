package serialize;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SerializeEntity serializeEntity = new SerializeEntity();
//        serializeEntity.setAddress("SH");
//        serializeEntity.setAge(1);
//        serializeEntity.setName("james");
//        serializeEntity.setPhone("12345678900");
//        SerializeEntity serializeEntity1 = new SerializeEntity();
//        serializeEntity1.setAddress("SH");
//        serializeEntity1.setAge(1);
//        serializeEntity1.setName("james");
//        serializeEntity1.setPhone("2345678765456");
//        System.out.println(serializeEntity.equals(serializeEntity1));

        File file = new File("/Users/james/shell/serialize.txt");
        SerializeEntity batchPay=new SerializeEntity("james", "SH", "1234567", 9999);
        FileOutputStream fos=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fos);
        objectOutputStream.writeObject(batchPay);
        objectOutputStream.close();
        getFile();

    }

    public static void getFile() throws IOException, ClassNotFoundException {
        File file = new File("/Users/james/shell/serialize.txt");
        InputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ob = new ObjectInputStream(fileInputStream);
        SerializeEntity serializeEntity = (SerializeEntity)ob.readObject();
        System.out.println(serializeEntity);
        ob.close();
        fileInputStream.close();

    }
}

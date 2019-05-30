package IO;

import java.io.*;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        File infile = new File("/Users/james/shell/txt.txt");
        //从文件中获取文件流  这是一个节点流
        FileInputStream inputStream = new FileInputStream(infile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        File file = new File("/Users/james/shell/java.txt");
        FileWriter fileWriter = new FileWriter(file);
        FileReader fileReader = new FileReader(infile);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line ;
        while ((line = bufferedReader1.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader1.close();
        bufferedReader.close();

    }
}

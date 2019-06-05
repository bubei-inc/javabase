package IO.nio;

import java.io.File;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-04 15:45
 * @description
 **/
public class NioTestCase {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for(int i = 0; i < intBuffer.capacity(); i++) {
            int random = new SecureRandom().nextInt(20);
            intBuffer.put(random);
        }
        intBuffer.flip();
        while(intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}

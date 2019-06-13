package IO.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author syp
 * @package_name IO.nio
 * @date 2019-06-05 09:57
 * @description
 **/
public class NioReadOnlyBuffer {
    public static void main(String[] args) {
//        buffer.asReadOnlyBuffer() 只读buffer
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.asReadOnlyBuffer();
    }
}

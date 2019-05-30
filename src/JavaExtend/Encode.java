package JavaExtend;

import JavaExtend.service.LoginPacket;
import JavaExtend.service.Packet;

/**
 * @author syp
 * @package_name JavaExtend
 * @date 2019-05-30 14:41
 * @description
 **/
public class Encode {
    public void encode(Packet packet) {
        System.out.println(((LoginPacket)packet).getAddress());
    }
}

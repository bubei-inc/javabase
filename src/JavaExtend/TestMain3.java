package JavaExtend;

import JavaExtend.service.LoginPacket;

/**
 * @author syp
 * @package_name JavaExtend
 * @date 2019-05-30 14:26
 * @description
 **/
public class TestMain3 {
    public static void main(String[] args) {
        LoginPacket loginPacket = new LoginPacket();
        Encode  encode = new Encode();
        loginPacket.setAddress("SH");
        loginPacket.setAge(11);
        loginPacket.setName("james");
        encode.encode(loginPacket);

    }
}

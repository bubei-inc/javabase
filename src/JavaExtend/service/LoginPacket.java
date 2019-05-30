package JavaExtend.service;

/**
 * @author syp
 * @package_name JavaExtend.service
 * @date 2019-05-30 14:39
 * @description
 **/
public class LoginPacket extends Packet {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void testPacket() {
        System.out.println("loginPacket");
    }

    @Override
    public String toString() {
        return "LoginPacket{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}


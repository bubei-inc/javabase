package Polymorphism;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

/**
 * @author syp
 * @package_name Polymorphism
 * @date 2019-05-30 15:19
 * @description  java 多态
 **/
public class TestMain {
    public static void main(String[] args) {
        Animal animal = new Cat();
        ((Cat)animal).run();
        MidFun midFun = new MidFun();
        midFun.testFun(new Bird());
    }
}

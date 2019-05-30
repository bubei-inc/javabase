package Polymorphism;

/**
 * @author syp
 * @package_name Polymorphism
 * @date 2019-05-30 15:02
 * @description
 **/
public class Bird extends Animal{
    private String address = "Sky";
    @Override
    public void eat() {
        System.out.println("我是鸟我能吃虫子！");
    }
    public void fly() {
        System.out.println("bird can fly!");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "address='" + address + '\'' +
                '}';
    }
}

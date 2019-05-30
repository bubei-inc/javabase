package Polymorphism;

/**
 * @author syp
 * @package_name Polymorphism
 * @date 2019-05-30 15:01
 * @description
 **/
public class Cat extends Animal{
    private String address;

    @Override
    public void eat() {
        System.out.println("my favorite food is mouse");

    }

    public void run() {
        System.out.println("cat can run fast");
    }
}

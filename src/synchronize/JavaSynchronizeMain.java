package synchronize;

/**
 * @author syp
 * @package_name synchronize
 * @date 2019-06-12 15:05
 * @description
 **/
public class JavaSynchronizeMain {
    public static void main(String[] args) throws InterruptedException {
        JavaSynchronize javaSynchronize = new JavaSynchronize();
        Thread thread = new Thread(javaSynchronize,"test1");
        Thread thread1 = new Thread(javaSynchronize, "test2");
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
        System.out.println(JavaSynchronize.i);
    }
}

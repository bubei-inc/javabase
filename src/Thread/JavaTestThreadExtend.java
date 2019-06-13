package Thread;

/**
 * @author syp
 * @package_name Thread
 * @date 2019-06-13 09:27
 * @description
 **/
public class JavaTestThreadExtend {
    public static void main(String[] args) throws InterruptedException {
        JavaExtendThread javaExtendThread = new JavaExtendThread();
//        Thread thread1 = new Thread(javaExtendThread,"thread1");
//        Thread thread2 = new Thread(javaExtendThread,"thread2");
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();

        JavaExtendThread javaExtendThread1 = new JavaExtendThread();

        javaExtendThread.start();
        javaExtendThread1.start();
    }
}

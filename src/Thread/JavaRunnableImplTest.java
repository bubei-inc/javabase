package Thread;


/**
 * @author syp
 * @package_name Thread
 * @date 2019-06-13 09:33
 * @description
 **/
public class JavaRunnableImplTest {
    public static void main(String[] args) {
        JavaImplementsRunnable javaImplementsRunnable = new JavaImplementsRunnable();
        Thread thread1 = new Thread(javaImplementsRunnable, "runnable1");
        Thread thread2 = new Thread(javaImplementsRunnable, "Runnable2");
        thread1.start();
        thread2.start();
//      Runnable实现的时候使用Thread创建实例是因为 如果只调用run函数来实现线程的话 这边只会启动一个线程不会启动多线程 对测试没有很大帮助

    }
}

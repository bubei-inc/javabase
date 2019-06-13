package synchronize;

/**
 * @author syp
 * @package_name synchronize
 * @date 2019-06-12 15:02
 * @description
 **/
public class JavaSynchronize implements Runnable {

    static int i = 0;

    public synchronized void increase() {
        i++;
        System.out.println(i);
    }
    @Override
    public void run() {
        for(int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName());
            increase();

        }

    }
}

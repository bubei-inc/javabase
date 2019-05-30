package Thread;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
    private Lock lock = new ReentrantLock();
    private static int count = 100;
    @Override
    public void run() {
        while(count > 0) {
            if(lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + "now count value is " + --count);
                lock.unlock();
            }

        }

    }
}

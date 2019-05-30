package Thread;

public class JoinTest implements  Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName);

    }
}

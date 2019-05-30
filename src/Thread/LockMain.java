package Thread;

public class LockMain {
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Thread thread1 = new Thread(lockTest,"test1");
        Thread thread2 = new Thread(lockTest, "test2");
        Thread thread3 = new Thread(lockTest, "test3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

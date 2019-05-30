package Thread;

public class mainClass {
    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest= new JoinTest();

        Thread t1 = new Thread(joinTest, "thread01");
        Thread t2 = new Thread(joinTest, "thread02");
        Thread t3 = new Thread(joinTest, "thread03");
        t1.start();
        //t1.join();
        t2.start();
       // t2.join();
        t3.start();
        //t3.join();
    }
}

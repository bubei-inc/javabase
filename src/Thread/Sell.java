package Thread;

public class Sell implements Runnable {
    private  int ticket = 10;

    @Override
    public synchronized void run() {
        while (ticket > 0) {
            ticket--;
            System.out.println("当前票数为：" + ticket);
        }
    }
}

package Thread;

public class SellTicket {
    public static void main(String[] args) {
        Sell sellThread = new Sell();
        Thread thread = new Thread(sellThread);
        Thread thread1 = new Thread(sellThread);
        thread.start();
        thread1.start();


    }


}

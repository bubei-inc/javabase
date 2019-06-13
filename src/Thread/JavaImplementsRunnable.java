package Thread;

/**
 * @author syp
 * @package_name Thread
 * @date 2019-06-13 09:26
 * @description
 **/
public class JavaImplementsRunnable implements Runnable {
    private int i = 5;

//    synchronized void increase() {
//        i++;
//    }
//
    @Override
    public void run() {
        while(true) {
            if(i < 0) {
                break;
            }else {
                System.out.println(Thread.currentThread().getName()  +" ,left:" + i--);
            }
        }
    }
}

import service.MyThread;
//import service.MyThreadLocal;
import service.TeatThreadLock;
import service.Test;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
//        MyThreadLocal myThreadLocalA = new MyThreadLocal();
//        MyThreadLocal myThreadLocalB = new MyThreadLocal();
//        Thread threadA = new Thread(myThreadLocalA, "a");
//        Thread threadB= new Thread(myThreadLocalB, "b");
//
//        threadA.start();
//        threadB.start();
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(3);
        System.out.println( bigDecimal.divide(bigDecimal1, 0, BigDecimal.ROUND_UP));





    }
}

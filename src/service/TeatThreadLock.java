package service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TeatThreadLock {
    private Lock lock = new ReentrantLock();
    private int i = 0;
    public void addmethod() {
        try {
            System.out.println("NOW IS ---->" + i);
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                try{
                    i++;
                    System.out.println("---->" + i);
                }catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }

            }else {
                System.out.println("未获得lock");

            }
            System.out.println("end i is --->" + i);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

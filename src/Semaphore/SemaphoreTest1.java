package Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


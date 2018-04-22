package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketTest implements Runnable {

    private int TicketNum = 50;

    private Lock lock = new ReentrantLock();//线程锁

    @Override
    public void run() {
        while (TicketNum > 0) {
            if (TicketNum > 0) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "，售出第" + (TicketNum--) + "张票");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

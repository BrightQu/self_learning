package cn.self.concurrent.test02;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Java并发包里的Lock和Condition实现阻塞队列。
 * @author quliang
 * @param <T>
 */
public class BlockedQueue<T> {

    /**
     *
     */
    private final static int QUEUE_SIZE = 1024;

    /**
     *
     */
    private final static int TEST_DATA_SIZE = 10;

    /**
     *
     */
    private LinkedList<T> queue = new LinkedList<>();

    /**
     *
     */
    private final Lock lock = new ReentrantLock();

    /**
     *
     */
    private final Condition notFull = lock.newCondition();

    /**
     *
     */
    private final Condition notEmpty = lock.newCondition();

    /**
     * @param data
     */
    public void push(T data) {
        lock.lock();
        try {
            while (queue.size() == QUEUE_SIZE) {
                notFull.await();
            }
            queue.add(data);
            System.out.println("+++++++++++++++++++++");
            printQueue();
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     */
    public void pop() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            T data = queue.pop();
            System.out.println("---------------------");
            printQueue();
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     */
    public void printQueue() {
        System.out.println(queue.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BlockedQueue<String> blockedQueue = new BlockedQueue<>();
        //        queue.push("aaa");
        //        queue.push("bbb");
        //        queue.push("ccc");
        //        queue.printQueue();
        //        queue.pop();
        //        queue.pop();
        //        queue.printQueue();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < TEST_DATA_SIZE; ++i) {
                blockedQueue.push("XXX" + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < TEST_DATA_SIZE; ++i) {
                blockedQueue.pop();
            }
        });
        thread1.start();
        thread2.start();
    }
}

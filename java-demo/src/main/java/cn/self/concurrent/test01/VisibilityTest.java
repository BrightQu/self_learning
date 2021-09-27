package cn.self.concurrent.test01;

/**
 * 可见性问题测试：两个线程对一个变量进行累加
 */
public class VisibilityTest {

    private long count = 0;

    public void add() {
        int cnt = 0;
        while (cnt++ < 100000000) {
            count += 1;
        }
    }

    public static void main (String[] args) throws InterruptedException {
        final VisibilityTest test = new VisibilityTest();
        Thread thread1 = new Thread(()->{
            test.add();
        });
        Thread thread2 = new Thread(()->{
            test.add();
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("=======================");
        System.out.println(test.count);
    }
}

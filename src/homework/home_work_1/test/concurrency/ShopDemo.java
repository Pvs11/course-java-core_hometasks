package homework.home_work_1.test.concurrency;

import homework.home_work_1.main.concurrency.Consumer;
import homework.home_work_1.main.concurrency.Producer;
import homework.home_work_1.main.concurrency.ShopQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopDemo {
    public static void main(String[] args) {
        ShopQueue queue = new ShopQueue();
        Producer producer = new Producer(queue);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(queue);
            service.execute(consumer);
        }
    }
}

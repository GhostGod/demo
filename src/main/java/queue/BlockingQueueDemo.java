package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingDeque<String>(100);
		//创建3个生产者和1个消费者
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);

		Consumer consumer = new Consumer(queue);

		//创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		//执行线程
		pool.execute(producer1);
		pool.execute(producer2);
		pool.execute(producer3);
		pool.execute(consumer);

		//运行10秒后停止
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();

		//运行2秒后关闭线程池
		Thread.sleep(2 * 1000);
		pool.shutdown();
	}
}

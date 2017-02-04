package queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 生产者
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
public class Producer implements Runnable {

	private volatile boolean running = true;
	private BlockingQueue<String> queue;
	private AtomicInteger count = new AtomicInteger();

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		String data = "";
		Random random = new Random();
		try {
			while (running) {
				Thread.sleep(random.nextInt(1000));
				data = "data" + count.incrementAndGet();
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("放入队列失败");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("生产者线程退出！");
		}
	}

	public void stop() {
		running = false;
	}

}

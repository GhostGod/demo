package queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.util.StringUtils;

/**
 * 消费者
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
public class Consumer implements Runnable {

	private BlockingQueue<String> queue;
	private volatile boolean running = true;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();
		try {
			while (running) {
				String data = queue.poll(2, TimeUnit.SECONDS);
				if (StringUtils.hasText(data)) {
					System.out.println("拿到数据并消费" + data);
					Thread.sleep(random.nextInt(1000));
				} else {
					System.out.println("没有数据了");
					running = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("消费者线程退出！");
		}
	}

}

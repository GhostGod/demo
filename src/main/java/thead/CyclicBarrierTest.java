package thead;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏测试
 * @author liuyang6-os
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		int count = 3;

		CyclicBarrier cyclicBarrier = new CyclicBarrier(count, new Runnable() {

			@Override
			public void run() {
				System.out.println("我就试试");
			}
		});

		for (int i = 0; i < count; i++) {
			new ThreadTest(cyclicBarrier).start();
		}
	}
}

class ThreadTest extends Thread {
	CyclicBarrier cyclicBarrier;

	public ThreadTest(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getId() + " start");
			Thread.sleep(new Random().nextInt(5) * 1000L);
			System.out.println(Thread.currentThread().getId() + " end");
			cyclicBarrier.await();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

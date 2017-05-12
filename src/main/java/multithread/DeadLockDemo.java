package multithread;
/**
 * 死锁DEMO
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
public class DeadLockDemo {
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public static void main(String[] args) {
		DeadLockDemo deadLockDemo = new DeadLockDemo();
		ThreadA a = deadLockDemo.new ThreadA();
		ThreadB b = deadLockDemo.new ThreadB();
		a.start();
		b.start();
	}

	class ThreadA extends Thread {

		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("threadA 已经获取lock1");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("threadA 已经获取lock2");
				}
			}
		}

	}

	class ThreadB extends Thread {

		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println("threadB 已经获取lock2");
				synchronized (lock1) {
					System.out.println("threadB 已经获取lock1");
				}
			}
		}

	}
}

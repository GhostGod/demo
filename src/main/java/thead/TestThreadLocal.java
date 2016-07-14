package thead;

public class TestThreadLocal {
	final static ThreadLocal<People> threadLocal = new ThreadLocal<People>() {

		@Override
		protected People initialValue() {
			return new People("wang", "女");
		}

	};

	public static void main(String[] args) throws InterruptedException {

		new Thread(new Runnable() {

			@Override
			public void run() {
				threadLocal.get().sex = "";
				System.out.println(threadLocal.get());
			}
		}).start();
		Thread.sleep(1000);
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(threadLocal.get());
			}
		}).start();
	}
}

class People {
	String name;
	String sex;

	public People(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", sex=" + sex + "]";
	}

}
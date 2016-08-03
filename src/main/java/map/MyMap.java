package map;

public class MyMap {
	java.util.TreeMap<String, String> a;
	java.util.LinkedHashMap<String, String> b;

	public static void main(String[] args) throws Exception {
		/*LinkedHashMap<String, String> c = new LinkedHashMap<>(10, 0.8f, true);
		c.put("1", "1");
		c.put("2", "2");
		c.put("3", "3");
		c.put("4", "4");
		c.get("1");
		c.get("2");
		c.get("1");
		for (Entry e : c.entrySet()) {
			System.out.println(e.getKey() + "-" + e.getValue());
		}
		CyclicBarrier cb = new CyclicBarrier(2);
		cb.await();
		int[] datas = new int[] { 1, 2, 3, 4, 5 };
		List list = Arrays.asList(datas);
		System.out.println(list.size());
		System.out.println(9 >> 1);
		HashMap m = new HashMap();
		m.put(null, "a");
		m.put("1", "1");
		m.put("2", "2");
		System.out.println(m.get(null));
		System.out.println(17 & 3);
		System.out.println(16 & 3);
		System.out.println(15 & 3);
		System.out.println(14 & 3);
		WeakReference<String> a = new WeakReference<String>("");
		System.out.println(13 & 3);
		System.out.println(Thread.currentThread().getName());
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(null);
		MyThread[] threads = new MyThread[3];
		for (int i = 0; i < 3; i++) {
			threads[i] = new MyThread();
			threads[i].no = i;
			threads[i].setDaemon(true);
			threads[i].start();
		}
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			synchronized (threads[i]) {
				threads[i].notify();
			}
		}
		FileInputStream f = new FileInputStream(new File(""));
		f.getChannel();
		Selector s = Selector.open();
		s.close();
		ServerSocketChannel*/

		ClassLoader loader = MyMap.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		System.out.println(loader);
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println(i);
		}
	}

	static int i;

	public static void recursion() {
		i++;
		recursion();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMap other = (MyMap) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

}

class MyThread extends Thread {

	public int no = 0;

	public void run() {
		System.out.println("第" + this.no + "个线程开始等待5分钟");
		try {
			synchronized (this) {
				this.wait(5 * 60 * 1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception  
			e.printStackTrace();
		}
		System.out.println("第" + this.no + "个线程被唤醒");
	}
}

class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}

}

class B extends A {
	public String show(B obj) {
		return ("B and B");
	}

	public String show(A obj) {
		return ("B and A");
	}
}

class C extends B {

}

class D extends B {

}

class Test {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println("1--" + a1.show(b));
		System.out.println("2--" + a1.show(c));
		System.out.println("3--" + a1.show(d));
		System.out.println("4--" + a2.show(b));
		System.out.println("5--" + a2.show(c));
		System.out.println("6--" + a2.show(d));
		System.out.println("7--" + b.show(b));
		System.out.println("8--" + b.show(c));
		System.out.println("9--" + b.show(d));
	}
}
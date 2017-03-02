package test;

public class TestMs {
	public static void main(String[] args) {
		Long a = System.currentTimeMillis();
		int i = 0;
		System.out.println(a);
		while (System.currentTimeMillis() - a < 1) {
			System.out.println(i++);
		}
		a = System.currentTimeMillis();
		System.out.println(a);
	}
}

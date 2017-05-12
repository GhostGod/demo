package sort;

/**
 * 快速排序
 * @author liuyang
 *
 */
public class QuickSort {
	public int[] sort(int[] a, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int x = a[i];
			while (i < j) {
				while (i < j && x < a[j]) {
					j--;
				}
				if (i < j) {
					a[i] = a[j];
					i++;
				}
				while (i < j && x > a[i]) {
					i++;
				}
				if (i < j) {
					a[j] = a[i];
					j--;
				}
			}
			a[i] = x;
			sort(a, left, i - 1);
			sort(a, i + 1, right);
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 9, 8, 7, 2, 3, 4, 5 };
		System.out.print("排序前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print("[" + a[i] + "]");
		}
		new QuickSort().sort(a, 0, a.length - 1);
		System.out.println("");
		System.out.print("排序后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print("[" + a[i] + "]");
		}
	}
}

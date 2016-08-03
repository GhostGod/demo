package com.liuyang.util;

//全排列
public class Permutation {
	public static void allPerm(int[] str, int begin, int end) {
		if (begin == end) {
			for (int i : str) {
				System.out.print(i);
			}

			System.out.println();
		} else {
			for (int i = begin; i <= end; i++) {
				int temp = str[i];
				str[i] = str[begin];
				str[begin] = temp;
				allPerm(str, begin + 1, end);
				str[begin] = str[i];
				str[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] str = new int[] { 1, 2, 3 };
		Permutation.allPerm(str, 0, 2);

	}
}

package com.liuyang.util;

import java.util.Arrays;

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
		int[] s = new int[] { 1, 2, 3 };
		System.out.println(Arrays.equals(str, s));
		for (int i : Arrays.stream(str).map(x -> x * x).toArray()) {
			System.out.print(i);
		}
		//Permutation.allPerm(str, 0, 2);
	}
}

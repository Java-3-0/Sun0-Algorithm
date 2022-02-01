package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2798 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		Integer[] arr = new Integer[n];
		int maxnum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int num = arr[i] + arr[j] + arr[k];
					if (num <= m && num >= maxnum)
						maxnum = num;

				}
			}
		}
		System.out.println(maxnum);
	}

}

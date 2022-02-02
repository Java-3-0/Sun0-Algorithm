package net.acmicpc;

import java.util.Scanner;

public class baekjoon_2231 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		boolean flg = false;
		for (int i = 0; i <= n; i++) {
			int num = i;
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if (i + sum == n) {
				flg = true;
				System.out.println(i);
				break;
			}
		}
		if (!flg)
			System.out.println("0");
	}

}

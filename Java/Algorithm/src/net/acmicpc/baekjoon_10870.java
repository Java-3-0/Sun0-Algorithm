package net.acmicpc;

import java.util.Scanner;

public class baekjoon_10870 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(Fibonacci(in.nextInt()));

	}

	private static int Fibonacci(int num) {
		if (num == 0)
			return 0;
		else if (num == 1)
			return 1;
		else
			return Fibonacci(num - 1) + Fibonacci(num - 2);
	}

}

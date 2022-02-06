package net.acmicpc;

import java.util.Scanner;

public class baekjoon_2447 {
	private static String[][] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printStar(n);
	}

	private static void printStar(int n) {
		StringBuilder line1 = new StringBuilder();
		StringBuilder line2 = new StringBuilder();
		StringBuilder line3 = new StringBuilder();

		if (n == 3) {
			line1.append("***");
			line2.append("* *");
			line3.append("***");
		} else
			printStar(n / 3);

		System.out.println(line1.toString());
		System.out.println(line2.toString());
		System.out.println(line3.toString());
		return;
	}

}

package net.acmicpc;

import java.util.Scanner;

public class baekjooon_11729 {

	public static StringBuilder sb = new StringBuilder();
	public static int cnt = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		Hanoi("1", "2", "3", num);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	private static void Hanoi(String a, String b, String c, int fin) {
		if (fin == 1) {
			sb.append(a + " " + c + "\n");
			cnt++;
			return;
		} else {
			Hanoi(a, c, b, fin - 1);
			sb.append(a + " " + c + "\n");
			cnt++;
			Hanoi(b, a, c, fin - 1);
		}
	}

}

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int num = 666;
		while (n > 0) {
			if (String.valueOf(num).contains("666")) {
				n -= 1;
			}
			num++;
		}
		System.out.println(num - 1);
	}

}

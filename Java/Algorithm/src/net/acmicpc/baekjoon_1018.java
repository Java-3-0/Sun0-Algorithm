package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1018 {

	private static String[][] board;
	private static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String num = bf.readLine();

		StringTokenizer st = new StringTokenizer(num);

		size = new int[2];
		size[0] = Integer.parseInt(st.nextToken());
		size[1] = Integer.parseInt(st.nextToken());

		board = new String[size[0]][];
		int minnum = size[0] * size[1];

		for (int i = 0; i < size[0]; i++) {
			board[i] = bf.readLine().split("");
		}
		for (int i = 0; i < size[0] - 7; i++) {
			for (int j = 0; j < size[1] - 7; j++) {
				minnum = Math.min(minnum, findboard(i, j));
			}
		}
		System.out.println(minnum);
	}

	private static int findboard(int a, int b) {
		String[] str = { "W", "B" };
		int count = 0;
		for (int i = a; i < a + 8; i++) {
			for (int j = b; j < b + 8; j++) {
				if (!(str[(i + j - a - b) % 2].equals(board[i][j]))) {
					count += 1;
				}
			}
		}
		return Math.min(count, 64 - count);
	}

}

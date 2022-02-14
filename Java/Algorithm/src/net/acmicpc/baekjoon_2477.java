//14280kb, 120ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());

		int[][] board = new int[6][2];

		int x = 0, index_x = 0;
		int y = 0, index_y = 0;

		for (int i = 0; i < 6; i++) {
			String[] arr = bf.readLine().split(" ");
			board[i][0] = Integer.parseInt(arr[0]);
			board[i][1] = Integer.parseInt(arr[1]);

			if (board[i][0] == 1 || board[i][0] == 2) {
				x = Math.max(x, board[i][1]);
				if (x == board[i][1])
					index_x = i;
			} else {
				y = Math.max(y, board[i][1]);
				if (y == board[i][1])
					index_y = i;
			}
		}

		int size = x * y;

		System.out.println((size - board[(index_x + 3) % 6][1] * board[(index_y + 3) % 6][1]) * num);

	}

}

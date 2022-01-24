package net.acmicpc;

import java.util.Scanner;

public class baekjoon_2615 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[][] board = new int[19][19];
		int[] dx = { 0, 1, 1, 1 };
		int[] dy = { 1, 1, 0, -1 };
		int win = 0;
		int[] x = { 0, 0, 0, 0, 0 };
		int[] y = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = in.nextInt();
			}
		}
		aa: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 0)
					continue;
				else if (board[i][j] == 1) {

					for (int k = 0, now_x, now_y; k < 4; k++) {
						now_x = i + dx[k];
						now_y = j + dy[k];
						int cnt = 0;
						while (now_x >= 0 && now_x < 19 && now_y >= 0 && now_y < 19 && board[now_x][now_y] == 1) {
							x[cnt] = now_x;
							y[cnt] = now_y;
							cnt++;

							now_x += dx[k];
							now_y += dy[k];
							if (cnt > 4)
								break;
						}
						if (cnt == 4) {
							now_x = i - dx[k];
							now_y = j - dy[k];
							if ((now_x < 0 || now_x >= 19 || now_y < 0 || now_y >= 19) || (now_x >= 0 && now_x < 19
									&& now_y >= 0 && now_y < 19 && board[now_x][now_y] != 1)) {
								x[cnt] = i;
								y[cnt] = j;
								win = 1;
								break aa;
							}
						}
					}
				} else if (board[i][j] == 2) {

					for (int k = 0, now_x, now_y; k < 4; k++) {
						now_x = i + dx[k];
						now_y = j + dy[k];
						int cnt = 0;
						while (now_x >= 0 && now_x < 19 && now_y >= 0 && now_y < 19 && board[now_x][now_y] == 2) {
							x[cnt] = now_x;
							y[cnt] = now_y;
							cnt++;

							now_x += dx[k];
							now_y += dy[k];
							if (cnt > 4)
								break;
						}
						if (cnt == 4) {
							now_x = i - dx[k];
							now_y = j - dy[k];
							if ((now_x < 0 || now_x >= 19 || now_y < 0 || now_y >= 19) || (now_x >= 0 && now_x < 19
									&& now_y >= 0 && now_y < 19 && board[now_x][now_y] != 2)) {
								x[cnt] = i;
								y[cnt] = j;
								win = 2;
								break aa;
							}
						}
					}
				}
			}
		}
		int index = 0, cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (y[i] < y[index])
				index = i;
			else if (y[i] == y[index])
				cnt++;
		}
		if (cnt == 5) {
			for (int i = 0; i < 5; i++) {
				if (x[i] < x[index])
					index = i;
			}
		}
		System.out.println(win);
		if (win != 0)
			System.out.println(x[index] + 1 + " " + (y[index] + 1));

	}

}

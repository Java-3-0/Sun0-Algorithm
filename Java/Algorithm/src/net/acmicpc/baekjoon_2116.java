//19588kb,196ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2116 {

	private static int[][] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		dice = new int[n][6];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum, maxsum = 0;
		for (int i = 0; i < 6; i++) {
			sum = 0;
			int now = dice[0][i];
			int opposite = findOpposite(i, 0);
			if (!is6(now, opposite))
				sum += 6;
			else if (!is5(now, opposite))
				sum += 5;
			else if (!is4(now, opposite))
				sum += 4;
			for (int j = 1; j < n; j++) {
				now = opposite;
				opposite = findOpposite(findIndex(now, j), j);
				if (!is6(now, opposite))
					sum += 6;
				else if (!is5(now, opposite))
					sum += 5;
				else if (!is4(now, opposite))
					sum += 4;
			}
			if (maxsum < sum)
				maxsum = sum;
		}
		System.out.println(maxsum);
	}

	private static boolean is4(int now, int opposite) {
		return now == 4 || opposite == 4;
	}

	private static boolean is5(int now, int opposite) {
		return now == 5 || opposite == 5;
	}

	private static boolean is6(int now, int opposite) {
		return now == 6 || opposite == 6;
	}

	private static int findIndex(int now, int j) {
		for (int i = 0; i < 6; i++) {
			if (dice[j][i] == now)
				return i;
		}
		return 0;
	}

	private static int findOpposite(int i, int j) {
		int opposite = 0;
		switch (i) {
		case 0:
			opposite = dice[j][5];
			break;
		case 1:
			opposite = dice[j][3];
			break;
		case 2:
			opposite = dice[j][4];
			break;
		case 3:
			opposite = dice[j][1];
			break;
		case 4:
			opposite = dice[j][2];
			break;
		case 5:
			opposite = dice[j][0];
			break;
		}
		return opposite;
	}

}

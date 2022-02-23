//15512kb, 112ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(bf.readLine());

		int[][] arr = new int[c][r];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		if (k > c * r)
			System.out.println("0");
		else {
			int i = 0, j = -1, index = 0;
			for (int t = 1; t <= k; t++) {
				i = i + dx[index];
				j = j + dy[index];
				if (i < 0 || i >= c || j < 0 || j >= r || arr[i][j] != 0) {
					i -= dx[index];
					j -= dy[index];
					index = (index + 1) % 4;
					t--;
				}
				arr[i][j] = t;
			}
			System.out.println((i + 1) + " " + (j + 1));

		}
	}
}

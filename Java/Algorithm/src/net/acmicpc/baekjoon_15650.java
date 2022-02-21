//11548kb,80ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_15650 {

	private static StringBuilder sb;
	private static int n, r;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		Permutation(0, 0);
		System.out.println(sb.toString());
	}

	private static void Permutation(int i, int cnt) {
		if (cnt == r) {
			for (int j = 0; j < visited.length; j++) {
				if (visited[j]) {
					sb.append(j + 1 + " ");
				}
			}
			sb.append("\n");
			return;
		}
		if (i >= n)
			return;

		visited[i] = true;
		Permutation(i + 1, cnt + 1);
		visited[i] = false;
		Permutation(i + 1, cnt);
	}

}

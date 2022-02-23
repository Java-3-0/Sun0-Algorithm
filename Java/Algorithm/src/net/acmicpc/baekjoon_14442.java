package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_14442 {

	private static int[] dx, dy;
	private static int N, M, K, mincnt;
	private static boolean[][][] visited;
	private static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new char[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = bf.readLine().toCharArray();
		}

		visited = new boolean[11][N][M];
		dx = new int[] { 0, 1, 0, -1 };
		dy = new int[] { 1, 0, -1, 0 };

		mincnt = Integer.MAX_VALUE;

		visited[0][0][0] = true;

		Queue<Integer[]> que = new LinkedList<Integer[]>();
		que.offer(new Integer[] { 0, 0, 1, 0 });

		while (!que.isEmpty()) {
			Integer[] now = que.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];
			int flg = now[3];
			if (x == N - 1 && y == M - 1) {
				mincnt = Math.min(mincnt, cnt);
			}
			for (int k = 0; k < 4; k++) {
				int now_x = x + dx[k];
				int now_y = y + dy[k];
				if (now_x >= 0 && now_x < N && now_y >= 0 && now_y < M && !visited[flg][now_x][now_y]) {
					if (arr[now_x][now_y] == '0') {
						visited[flg][now_x][now_y] = true;
						que.offer(new Integer[] { now_x, now_y, cnt + 1, flg });
					} else if (flg < K) {
						visited[flg][now_x][now_y] = true;
						que.offer(new Integer[] { now_x, now_y, cnt + 1, flg + 1 });
					}
				}
			}
		}
		mincnt = mincnt == Integer.MAX_VALUE ? -1 : mincnt;
		System.out.println(mincnt);

	}

}

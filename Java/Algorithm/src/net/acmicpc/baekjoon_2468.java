// 55596kb, 304ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2468 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int[][] arr = new int[n][n];
		
		boolean[][] visited;
		Queue<int[]> que;
		
		// 비의 높이가 주어지지 않았으므로 비의 최대 높이 == 빌딩의 최대 높이
		int maxHeight = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][j]); // 최대 비 높이 구하기
			}
		}
		
		int maxcnt = 0;
		
		// 최대 비 높이까지 돌기
		for (int t = 0; t <= maxHeight; t++) {
			int cnt = 0;
			
			que = new LinkedList<int[]>();
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					// 방문하지 않았고 안전지대일 경우
					if (!visited[i][j] && arr[i][j] > t) {
						cnt++;
						// que에 넣기
						que.offer(new int[] { i, j });
						visited[i][j] = true;

						// 큐에 넣은 애의 사방탐색 -> 안전지대면 que에 넣기
						while (!que.isEmpty()) {
							int[] temp = que.poll(); // 현재 위치
							for (int k = 0; k < 4; k++) { // 현재 위치의 사방 탐색
								int now_x = temp[0] + dx[k];
								int now_y = temp[1] + dy[k];

								// 범위 안에 있고 방문하지 않았고 안전지대의 경우
								if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < n && !visited[now_x][now_y]
										&& arr[now_x][now_y] > t) {
									visited[now_x][now_y] = true;
									que.offer(new int[] { now_x, now_y });
								}
							}
						}
					}
				}
			}
			maxcnt = Math.max(maxcnt, cnt);
		}
		System.out.println(maxcnt);
	}

}

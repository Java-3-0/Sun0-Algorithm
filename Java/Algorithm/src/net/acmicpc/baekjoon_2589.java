// 60724kb, 244ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2589 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		char[][] arr = new char[x][y];
		Queue<int[]> que = new LinkedList<int[]>();
		Queue<int[]> que2 = new LinkedList<int[]>();
		boolean[][] visited = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < y; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

		int maxcnt = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!visited[i][j] && arr[i][j] == 'L') {
					que2 = new LinkedList<int[]>();
					visited[i][j] = true;
					que.offer(new int[] { i, j });

					// 큐에 넣은 애의 사방탐색 -> 안전지대면 que에 넣기
					while (!que.isEmpty()) {
						boolean flg = false;
						int[] temp = que.poll(); // 현재 위치
						for (int k = 0; k < 4; k++) { // 현재 위치의 사방 탐색
							int now_x = temp[0] + dx[k];
							int now_y = temp[1] + dy[k];
							// 범위 안에 있고 방문하지 않았고 안전지대의 경우
							if (now_x >= 0 && now_x < x && now_y >= 0 && now_y < y && !visited[now_x][now_y]
									&& arr[now_x][now_y] == 'L') {
								flg = true;
								visited[now_x][now_y] = true;
								que.offer(new int[] { now_x, now_y });

							}
						}
						if (!flg)
							que2.offer(temp);// 첨단에 있는 애들 넣기
					}

					while (!que2.isEmpty()) {
						boolean[][] visited1 = new boolean[x][y];
						Queue<int[]> que3 = new LinkedList<int[]>();

						int[] first = que2.poll();

						que3.offer(new int[] { first[0], first[1], 0 });
						visited1[first[0]][first[1]] = true;

						while (!que3.isEmpty()) {
							int[] temp = que3.poll(); // 현재 위치

							for (int k = 0; k < 4; k++) { // 현재 위치의 사방 탐색
								int now_x = temp[0] + dx[k];
								int now_y = temp[1] + dy[k];
								// 범위 안에 있고 방문하지 않았고 안전지대의 경우
								if (now_x >= 0 && now_x < x && now_y >= 0 && now_y < y && !visited1[now_x][now_y]
										&& arr[now_x][now_y] == 'L') {
									visited1[now_x][now_y] = true;
									que3.offer(new int[] { now_x, now_y, temp[2] + 1 });
									maxcnt = Math.max(maxcnt, temp[2] + 1);

								}
							}
						}
					}
				}
			}
		}
		System.out.println(maxcnt);
	}

}

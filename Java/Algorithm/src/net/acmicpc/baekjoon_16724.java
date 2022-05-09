/***
 * 78800kb
 * 492ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16724 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dk = {2, 3, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                switch (str.charAt(j)) {
                    case 'U':
                        arr[i][j] = 3;
                        break;
                    case 'D':
                        arr[i][j] = 1;
                        break;
                    case 'L':
                        arr[i][j] = 2;
                        break;
                    case 'R':
                        arr[i][j] = 0;
                        break;
                }
            }
        }
        int index = 1;
        int cnt = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {

                    Queue<int[]> que = new LinkedList<>();
                    visited[i][j] = index;
                    que.offer(new int[]{i, j});

                    while (!que.isEmpty()) {

                        int[] now = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nowX = now[0] + dx[k];
                            int nowY = now[1] + dy[k];
                            if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && visited[nowX][nowY] == 0 && arr[nowX][nowY] == dk[k]) {
                                visited[nowX][nowY] = index;
                                que.offer(new int[]{nowX, nowY});
                            }
                        }

                        int nowX = now[0] + dx[arr[now[0]][now[1]]];
                        int nowY = now[1] + dy[arr[now[0]][now[1]]];
                        if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && visited[nowX][nowY] == 0) {
                            visited[nowX][nowY] = index;
                            que.offer(new int[]{nowX, nowY});
                        }
                    }
                    index++;
                }
            }
        }

        System.out.println(index - 1);

    }
}
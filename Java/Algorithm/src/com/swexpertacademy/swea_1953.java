/***
 * 25,404 kb
 * 132ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

    private static final int[][] dx = {{0, 1, 0, -1}, {1, -1}, {0, 0}, {0, -1}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] dy = {{1, 0, -1, 0}, {0, 0}, {1, -1}, {1, 0}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= test_case; t++) {

            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            boolean[][] visited = new boolean[n][m];
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{r, c, 1});
            visited[r][c] = true;

            while (!que.isEmpty()) {
                int[] now = que.poll();
                int x = now[0];
                int y = now[1];
                int dis = now[2];
                int tunnelType = arr[x][y] - 1;
                cnt++;
                if (dis == l) continue;
                int length = dx[tunnelType].length;

                for (int k = 0; k < length; k++) {
                    int nowX = x + dx[tunnelType][k];
                    int nowY = y + dy[tunnelType][k];
                    if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && !visited[nowX][nowY] && arr[nowX][nowY] != 0) {
                        // 갈 수 없는 경우 제외
                        if (dx[tunnelType][k] == 0 && dy[tunnelType][k] == 1) {
                            if (arr[nowX][nowY] == 2 || arr[nowX][nowY] == 4 || arr[nowX][nowY] == 5) continue;
                        } else if (dx[tunnelType][k] == 1 && dy[tunnelType][k] == 0) {
                            if (arr[nowX][nowY] == 3 || arr[nowX][nowY] == 5 || arr[nowX][nowY] == 6) continue;
                        } else if (dx[tunnelType][k] == 0 && dy[tunnelType][k] == -1) {
                            if (arr[nowX][nowY] == 2 || arr[nowX][nowY] == 6 || arr[nowX][nowY] == 7) continue;
                        } else {
                            if (arr[nowX][nowY] == 3 || arr[nowX][nowY] == 4 || arr[nowX][nowY] == 7) continue;
                        }

                        visited[nowX][nowY] = true;
                        que.offer(new int[]{nowX, nowY, dis + 1});
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

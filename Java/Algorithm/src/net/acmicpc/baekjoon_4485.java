//23668kb,364ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_4485 {
    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true) {
            int mindistance = Integer.MAX_VALUE;
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[][] arr = new int[n][n];
            int[][] distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
            que.offer(new Integer[]{0, 0, arr[0][0]});
            distance[0][0] = arr[0][0];
            while (!que.isEmpty()) {
                Integer[] now = que.poll();
                int x = now[0];
                int y = now[1];
                int now_distance = now[2];

                if (x == n - 1 && y == n - 1) {
                    mindistance = Math.min(mindistance, now_distance);
                }
                if (now_distance > distance[x][y]) continue;
                for (int k = 0; k < 4; k++) {
                    int now_x = x + dx[k];
                    int now_y = y + dy[k];
                    if (now_x >= 0 && now_x < n & now_y >= 0 && now_y < n && arr[now_x][now_y] + now_distance < distance[now_x][now_y]) {
                        distance[now_x][now_y] = arr[now_x][now_y] + now_distance;
                        que.offer(new Integer[]{now_x, now_y, distance[now_x][now_y]});
                    }
                }
            }
            System.out.println("Problem " + (t++) + ": " + mindistance);

        }
    }
}

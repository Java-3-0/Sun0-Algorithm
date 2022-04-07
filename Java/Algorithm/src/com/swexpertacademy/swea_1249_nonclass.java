/***
 * 30,324 kb
 * 208 ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class swea_1249_nonclass {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(bf.readLine());

            char[][] arr = new char[n][];

            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            boolean[][] visited = new boolean[n][n];

            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
            que.offer(new int[]{0, 0, 0});
            visited[0][0] = true;

            int finCost = 0;

            while (!que.isEmpty()) {
                int[] now = que.poll();
                if (now[0] == n - 1 && now[1] == n - 1) {
                    finCost = now[2];
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int nowX = now[0] + dx[k];
                    int nowY = now[1] + dy[k];
                    if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n && !visited[nowX][nowY]) {
                        visited[nowX][nowY] = true;
                        que.offer(new int[]{nowX, nowY, (arr[nowX][nowY] - '0') + now[2]});
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(finCost).append("\n");
        }
        System.out.println(sb);
    }
}

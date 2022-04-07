/***
 * 23,000 kb
 * 130 ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class swea_1249_class {
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

            PriorityQueue<pos> que = new PriorityQueue<pos>();
            que.offer(new pos(0, 0, 0));
            visited[0][0] = true;

            int finCost = 0;

            while (!que.isEmpty()) {
                pos now = que.poll();
                if (now.x == n - 1 && now.y == n - 1) {
                    finCost = now.dis;
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int nowX = now.x + dx[k];
                    int nowY = now.y + dy[k];
                    if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n && !visited[nowX][nowY]) {
                        visited[nowX][nowY] = true;
                        que.offer(new pos(nowX, nowY, (arr[nowX][nowY] - '0') + now.dis));
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(finCost).append("\n");
        }
        System.out.println(sb);
    }

    static class pos implements Comparable<pos> {
        int x;
        int y;
        int dis;

        pos(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }


        @Override
        public int compareTo(pos o) {
            return this.dis - o.dis;
        }
    }
}

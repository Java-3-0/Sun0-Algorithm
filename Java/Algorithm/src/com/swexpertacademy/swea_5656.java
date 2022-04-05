/***
 * 89,640 kb
 * 302 ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int n, w, h, bomb, minnum;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new int[h][w];

            minnum = Integer.MAX_VALUE;
            bomb = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] != 0)
                        bomb++;
                }
            }

            DFS(0, 0);
            sb.append("#").append(t).append(" ").append(minnum == Integer.MAX_VALUE ? 0 : minnum).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int depth, int cnt) {
        if (depth == n) { // 폭발 횟수 도달
            minnum = Math.min(minnum, bomb - cnt);
            return;
        }
        for (int i = 0; i < w; i++) {
            Queue<int[]> explodedBomb = Explode(i);
            Queue<int[]> gravity = GiveGravity();

            if (explodedBomb.size() > 0) {
                DFS(depth + 1, cnt + explodedBomb.size());
                Undo(gravity);
                Undo(explodedBomb);
            }
        }
    }

    private static Queue<int[]> GiveGravity() {
        Queue<int[]> temp = new LinkedList<>();
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            for (int j = h - 1; j >= 0; j--) {
                que.offer(new int[]{j, i, arr[j][i]});
            }

            for (int j = h - 1; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    que.poll();
                } else {

                    while (!que.isEmpty() && que.peek()[2] == 0) {
                        que.poll();
                    }
                    if (!que.isEmpty()) {
                        int[] now = que.poll();
                        temp.offer(now);
                        arr[j][i] = now[2];
                        arr[now[0]][now[1]] = 0;
                    }
                }

            }
        }
        return temp;
    }

    private static void Undo(Queue<int[]> explodedBomb) {
        while (!explodedBomb.isEmpty()) {
            int[] now = explodedBomb.poll();
            int x = now[0];
            int y = now[1];
            int value = now[2];

            arr[x][y] = value;
        }
    }

    private static Queue<int[]> Explode(int index) {
        Queue<int[]> temp = new LinkedList<>();

        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            if (arr[i][index] != 0) {
                que.offer(new int[]{i, index, arr[i][index]});
                arr[i][index] = 0;
                break;
            }
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();

            int x = now[0];
            int y = now[1];
            int distance = now[2];

            temp.offer(now);

            for (int i = 1; i < distance; i++) {
                for (int j = 0; j < 4; j++) {
                    int nowX = x + dx[j] * i;
                    int nowY = y + dy[j] * i;

                    if (nowX >= 0 && nowX < h && nowY >= 0 && nowY < w && arr[nowX][nowY] != 0) {
                        que.offer(new int[]{nowX, nowY, arr[nowX][nowY]});
                        arr[nowX][nowY] = 0;
                    }
                }
            }
        }
        return temp;
    }
}

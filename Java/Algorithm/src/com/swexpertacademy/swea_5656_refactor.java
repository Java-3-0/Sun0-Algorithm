/***
 * 44,992 kb
 * 181 ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656_refactor {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int n, w, h, bomb, minnum;
    private static int[][] arr;
    private static int[] topIndex;

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
            topIndex = new int[w];
            Arrays.fill(topIndex, -1);
            minnum = Integer.MAX_VALUE;
            bomb = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] != 0 && topIndex[j] == -1)
                        topIndex[j] = i;
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
        if (minnum == 0)
            return;
        if (bomb == cnt || depth == n) { // 폭발 횟수 도달
            minnum = Math.min(minnum, bomb - cnt);
            return;
        }
        for (int i = 0; i < w; i++) {
            Queue<int[]> explodedBomb = null;
            if (topIndex[i] != -1)
                explodedBomb = Explode(i);
            Queue<int[]> gravity = GiveGravity();

            if (explodedBomb != null && explodedBomb.size() > 0) {
                DFS(depth + 1, cnt + explodedBomb.size());
                if (minnum == 0)
                    return;
                Undo(gravity);
                Undo(explodedBomb);
            }
        }
    }

    private static Queue<int[]> GiveGravity() {
        Queue<int[]> temp = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            int j = h - 1;
            while (j >= 0) {
                if (arr[j][i] == 0) {
                    int nowJ = j - 1;
                    while (nowJ >= 0 && arr[nowJ][i] == 0) nowJ--;
                    if (nowJ == -1) break;
                    arr[j][i] = arr[nowJ][i];
                    temp.offer(new int[]{nowJ, i, arr[nowJ][i]});
                    arr[nowJ][i] = 0;
                    topIndex[i] = j;
                }
                if (arr[j][i] != 0)
                    topIndex[i] = j;
                j--;
            }
            if (arr[h - 1][i] == 0)
                topIndex[i] = -1;
        }
        return temp;
    }

    private static void Undo(Queue<int[]> explodedBomb) {
        while (!explodedBomb.isEmpty()) {
            int[] now = explodedBomb.poll();
            if (topIndex[now[1]] == -1)
                topIndex[now[1]] = now[0];
            else
                topIndex[now[1]] = Math.min(topIndex[now[1]], now[0]);
            arr[now[0]][now[1]] = now[2];
        }
    }

    private static Queue<int[]> Explode(int index) {
        Queue<int[]> temp = new LinkedList<>();

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{topIndex[index], index, arr[topIndex[index]][index]});
        arr[topIndex[index]][index] = 0;

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

/***
 * 294920mb
 * 708ks
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_14502 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] arr;
    private static int n, m, maxNum;
    private static int wall;
    private static Queue<pos> virusPosition;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wall = 0;
        virusPosition = new LinkedList<pos>();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    wall++;
                else if (arr[i][j] == 2)
                    virusPosition.offer(new pos(i, j));
            }
        }
        maxNum = 0;
        Combination(0);
        System.out.println(maxNum);
    }

    private static void Combination(int cnt) {
        if (cnt == 3) {
            int safeArea = (n * m) - (wall + 3) - CheckSafeArea();
            maxNum = Math.max(maxNum, safeArea);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    Combination(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static int CheckSafeArea() {
        int virus = 0;

        boolean[][] visited = new boolean[n][m];

        Queue<pos> nowVirus = new LinkedList<>();
        for (pos v : virusPosition) {
            visited[v.x][v.y] = true;
            nowVirus.offer(v);
        }

        while (!nowVirus.isEmpty()) {
            pos now = nowVirus.poll();
            virus++;

            for (int i = 0; i < 4; i++) {
                int nowX = now.x + dx[i];
                int nowY = now.y + dy[i];
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && !visited[nowX][nowY] && arr[nowX][nowY] == 0) {
                    visited[nowX][nowY] = true;
                    nowVirus.offer(new pos(nowX, nowY));
                }
            }
        }
        return virus;
    }

    static class pos {
        int x;
        int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

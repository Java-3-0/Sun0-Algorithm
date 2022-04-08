/***
 * 31832kb
 * 212ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_17135 {

    private static final int[] dx = {0, -1, 0};
    private static final int[] dy = {-1, 0, 1};

    private static int n, m, d, maxKillCount, enemyCount;
    private static boolean[] archerPosition;
    private static int[][] defaultArr, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        archerPosition = new boolean[m];
        enemyCount = 0;
        defaultArr = new int[n][m];
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                defaultArr[i][j] = Integer.parseInt(st.nextToken());
                if (defaultArr[i][j] == 1)
                    enemyCount++;
            }
        }
        maxKillCount = 0;

        SetArcher(0, 0);
        System.out.println(maxKillCount);
    }

    private static void SetArcher(int index, int archerCnt) {
        if (archerCnt == 3) {
            maxKillCount = Math.max(maxKillCount, KillArcher());
            return;
        }
        if (index >= m) return;

        archerPosition[index] = true;
        SetArcher(index + 1, archerCnt + 1);
        archerPosition[index] = false;
        SetArcher(index + 1, archerCnt);
    }

    private static int KillArcher() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = defaultArr[i][j];
            }
        }

        int killCount = 0;
        int nowEnemyCount = enemyCount;
        while (nowEnemyCount > 0) {
            killCount += ShootBow();
            nowEnemyCount = ApproachEnemy();
        }
        return killCount;
    }

    private static int ApproachEnemy() {
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    if (i + 1 < n) {
                        cnt++;
                        arr[i + 1][j] = 1;
                    }
                }
            }
        }
        return cnt;
    }

    private static int ShootBow() {
        int cnt = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (archerPosition[i]) {
                int[] killed = kill(i);
                if (killed != null) {
                    que.offer(killed);
                }
            }
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (arr[now[0]][now[1]] == 1) {
                cnt++;
                arr[now[0]][now[1]] = 0;
            }
        }
        return cnt;
    }

    private static int[] kill(int i) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{n, i, 0});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int dis = now[2];
            if (dis == d) continue;
            for (int j = 0; j < 3; j++) {
                int nowX = x + dx[j];
                int nowY = y + dy[j];
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && !visited[nowX][nowY] && (Math.abs(n - nowX) + Math.abs(i - nowY)) <= d) {
                    if (arr[nowX][nowY] == 1) {
                        return new int[]{nowX, nowY};
                    }
                    visited[nowX][nowY] = true;
                    que.offer(new int[]{nowX, nowY, dis + 1});
                }
            }
        }
        return null;
    }
}

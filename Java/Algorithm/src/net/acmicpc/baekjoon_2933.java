/***
 * 30268kb
 * 288ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2933 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    private static char[][] arr;
    private static int n;
    private static int m;
    private static Queue<int[]> que;
    private static PriorityQueue<int[]> Pque;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        int cnt = Integer.parseInt(bf.readLine());
        que = new ArrayDeque<>();
        Pque = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < cnt; i++) {
            int now = Integer.parseInt(st.nextToken());
            boolean isDestroyed;
            if (i % 2 == 0)
                isDestroyed = left(n - now);
            else
                isDestroyed = right(n - now);

            if (isDestroyed && canDownMineral())
                downMineral();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void downMineral() {
        Queue<int[]> temp = new ArrayDeque<>();
        boolean[] columnVisited = new boolean[m];

        int mincnt = Integer.MAX_VALUE;
        while (!Pque.isEmpty()) {
            int[] bottom = Pque.poll();
            temp.offer(bottom);
            if (!columnVisited[bottom[1]]) {
                columnVisited[bottom[1]] = true;
                int x = bottom[0];
                int y = bottom[1];

                int cnt = 0;
                while (x + 1 < n && arr[x++ + 1][y] == '.')
                    cnt++;

                mincnt = Math.min(cnt, mincnt);
            }
        }


        while (!temp.isEmpty()) {
            int[] bottom = temp.poll();
            int x = bottom[0];
            int y = bottom[1];
            arr[x + mincnt][y] = 'x';
            arr[x][y] = '.';
        }
    }

    private static boolean canDownMineral() {
        boolean[][] visited = new boolean[n][m];

        // 바닥에 연결된 미네랄들 검사
        // 맨 아랫줄만 먼저 넣어보기 -> 무조건 바닥에서부터 시작하니까
        int i = n - 1;
        for (int j = 0; j < m; j++) {
            if (!visited[i][j] && arr[i][j] == 'x') {
                visited[i][j] = true;
                que.offer(new int[]{i, j});
            }
        }
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            for (int j = 0; j < 4; j++) {
                int nowX = x + dx[j];
                int nowY = y + dy[j];
                if (isInRange(nowX, nowY) && !visited[nowX][nowY] && arr[nowX][nowY] == 'x') {
                    visited[nowX][nowY] = true;
                    que.offer(new int[]{nowX, nowY});
                }
            }
        }

        //이제 공중에 떠 있는 미네랄 검사
        for (i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 'x') {
                    visited[i][j] = true;
                    que.offer(new int[]{i, j});
                    findCluster(visited);
                    return true;
                }
            }
        }
        return false;
    }

    private static void findCluster(boolean[][] visited) {
        while (!que.isEmpty()) {
            int[] now = que.poll();
            Pque.offer(now);
            int x = now[0];
            int y = now[1];
            for (int j = 0; j < 4; j++) {
                int nowX = x + dx[j];
                int nowY = y + dy[j];
                if (isInRange(nowX, nowY) && !visited[nowX][nowY] && arr[nowX][nowY] == 'x') {
                    visited[nowX][nowY] = true;
                    que.offer(new int[]{nowX, nowY});
                }
            }
        }
    }

    private static boolean isInRange(int nowX, int nowY) {
        return nowX >= 0 && nowX < n && nowY >= 0 && nowY < m;
    }

    private static boolean right(int now) {
        for (int i = m - 1; i >= 0; i--) {
            if (arr[now][i] == 'x') {
                arr[now][i] = '.';
                return true;
            }
        }
        return false;
    }

    private static boolean left(int now) {
        for (int i = 0; i < m; i++) {
            if (arr[now][i] == 'x') {
                arr[now][i] = '.';
                return true;
            }
        }
        return false;
    }
}

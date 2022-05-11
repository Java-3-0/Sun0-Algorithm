/***
 * 83128kb
 * 304ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_17070 {
    public static int[] dx = {0, 1, 1}; // 수평, 대각선, 수직 순서
    public static int[] dy = {1, 1, 0};
    private static int[][] arr;
    private static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        cnt = 0;
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, new int[]{0, 1});
        System.out.println(cnt);
    }

    private static void DFS(int type, int[] now) {
        if (now[0] == n - 1 && now[1] == n - 1) {
            cnt++;
            return;
        }
        findRoute(now[0], now[1], type);
    }

    private static void findRoute(int a, int b, int type) {
        int start = 0;
        int finish = 0;
        switch (type) {
            case 0:
                finish = 2;
                break;
            case 2:
                start = 1;
                finish = 3;
                break;
            case 1:
                finish = 3;
                break;
        }
        for (int i = start; i < finish; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (isInRange(x, y) && canGo(x, y, i)) { // 범위 안에 있다면
                controlVisited(x, y, i, 1);
                DFS(i, new int[]{x, y});
                controlVisited(x, y, i, -1);
            }
        }
    }

    private static boolean canGo(int x, int y, int i) {
        switch (i) {
            case 0:
            case 2:
                if (arr[x][y] == 0) return true;
                break;
            case 1:
                if (arr[x - 1][y] == 0 && arr[x][y - 1] == 0 && arr[x][y] == 0)
                    return true;
                break;
        }
        return false;
    }

    private static void controlVisited(int x, int y, int i, int num) {
        switch (i) {
            case 0:
            case 2:
                arr[x][y] += num;
                break;
            case 1:
                arr[x - 1][y] += num;
                arr[x][y - 1] += num;
                arr[x][y] += num;
                break;
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

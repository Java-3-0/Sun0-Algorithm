/***
 * 98700kb
 * 744ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16946 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] arr;
    private static boolean[][] visitedArr;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visitedArr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visitedArr[i][j]) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        int cnt = 0;

        Queue<int[]> que = new ArrayDeque<>();
        HashSet<Integer> change = new HashSet<>();
        que.offer(new int[]{i, j});
        visitedArr[i][j] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            cnt++;
            for (int k = 0; k < 4; k++) {
                int nowX = x + dx[k];
                int nowY = y + dy[k];
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && !visitedArr[nowX][nowY]) {
                    if (arr[nowX][nowY] == 0) {
                        visitedArr[nowX][nowY] = true;
                        que.offer(new int[]{nowX, nowY});
                    } else {
                        change.add(nowX * 1000 + nowY);
                    }
                }
            }

        }

        for (Integer pos : change
        ) {
            arr[pos / 1000][pos % 1000] += cnt;
        }

        return;
    }
}

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2636 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] arr;
    private static int n;
    private static int m;
    private static Queue<Integer[]> edgeCheese;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        edgeCheese = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkOutside();
        findEdgeCheese();
        int cnt = 0;
        int lastCheeseCnt = 0;
        while (edgeCheese.size() > 0) {
            lastCheeseCnt = edgeCheese.size();

            melt();
            checkOutside();

            cnt++;
        }

        System.out.println(cnt);
        System.out.println(lastCheeseCnt);
    }

    private static void findEdgeCheese() {
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int now_x = i + dx[k];
                        int now_y = j + dy[k];
                        if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < m && arr[now_x][now_y] == 2) {
                            edgeCheese.offer(new Integer[]{i, j});
                            arr[i][j] = -1;
                            visited[i][j] = true;
                        }
                    }
                }
            }
        }
    }

    private static void melt() {
        Queue<Integer[]> newEdgeCheese = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        while (!edgeCheese.isEmpty()) {
            Integer[] now = edgeCheese.poll();
            arr[now[0]][now[1]] = 2; // 녹이기

            for (int i = 0; i < 4; i++) { // 사방탐색하면서 엣지 찾기
                int now_x = now[0] + dx[i];
                int now_y = now[1] + dy[i];
                if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < m && arr[now_x][now_y] == 1 && !visited[now_x][now_y]) {
                    newEdgeCheese.offer(new Integer[]{now_x, now_y});
                    arr[now_x][now_y] = -1;
                    visited[now_x][now_y] = true;
                }
            }

        }
        edgeCheese = newEdgeCheese;
        return;
    }

    private static void checkOutside() {
        boolean[][] visited = new boolean[n][m];
        Queue<Integer[]> outside = new LinkedList<>();
        outside.offer(new Integer[]{0, 0});
        visited[0][0] = true;
        arr[0][0] = 2;

        while (!outside.isEmpty()) {
            Integer[] now = outside.poll();
            for (int i = 0; i < 4; i++) {
                int now_x = now[0] + dx[i];
                int now_y = now[1] + dy[i];
                if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < m && (arr[now_x][now_y] == 0 || arr[now_x][now_y] == 2) && !visited[now_x][now_y]) {
                    outside.offer(new Integer[]{now_x, now_y});
                    visited[now_x][now_y] = true;
                    if (arr[now_x][now_y] == 0) {
                        arr[now_x][now_y] = 2;
                        for (int k = 0; k < 4; k++) {
                            int new_x = now_x + dx[k];
                            int new_y = now_y + dy[k];
                            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && arr[new_x][new_y] == 1 && !visited[new_x][new_y]) {
                                edgeCheese.offer(new Integer[]{new_x, new_y});
                                arr[new_x][new_y] = -1;
                                visited[new_x][new_y] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}

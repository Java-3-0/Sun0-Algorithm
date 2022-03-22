package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_17472 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n, m, index;
    private static int[] parent;
    private static ArrayList<int[]> edge;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DivideArea();
        MakeEdge();
        Collections.sort(edge, (o1, o2) -> (o1[2] - o2[2]));
        parent = new int[index];
        for (int i = 0; i < index; i++) {
            parent[i] = i;
        }
        int num = Kruskal();

        System.out.println(num);
    }

    private static int Kruskal() {
        int cnt = 0;
        int result = 0;
        for (int[] e : edge) {
            if (union(e[0] - 1, e[1] - 1)) {
                result += e[2];
                if (++cnt == index - 1)
                    return result;
            }
        }
        return -1;
    }

    private static int findset(int i) {
        if (parent[i] == i) // 내가 나라면 나는 루트
            return parent[i];
        return parent[i] = findset(parent[i]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findset(a);
        int bRoot = findset(b);
        if (aRoot == bRoot)
            return false;
        parent[bRoot] = aRoot;
        return true;
    }

    private static void MakeEdge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    // 현재 위치에서 4방향에 대해서
                    for (int k = 0; k < 4; k++) {
                        int cnt = 1;
                        int now_x = i + dx[k];
                        int now_y = j + dy[k];
                        while (isInRagne(now_x, now_y) && arr[now_x][now_y] == 0) {
                            now_x += dx[k];
                            now_y += dy[k];
                            cnt++;
                        }
                        cnt--;
                        if (cnt >= 2 && isInRagne(now_x, now_y) && arr[now_x][now_y] != 0 && arr[now_x][now_y] != arr[i][j]) {
                            edge.add(new int[]{arr[i][j], arr[now_x][now_y], cnt});
                        }
                    }
                }
            }
        }
    }

    private static void DivideArea() {
        index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    index++;
                    Queue<Integer[]> que = new LinkedList<>();
                    visited[i][j] = true;
                    arr[i][j] = index;
                    que.offer(new Integer[]{i, j});
                    while (!que.isEmpty()) {
                        Integer[] now = que.poll();
                        int x = now[0];
                        int y = now[1];
                        for (int k = 0; k < 4; k++) {
                            int now_x = x + dx[k];
                            int now_y = y + dy[k];
                            if (isInRagne(now_x, now_y) && !visited[now_x][now_y] && arr[now_x][now_y] == 1) {
                                visited[now_x][now_y] = true;
                                arr[now_x][now_y] = index;
                                que.offer(new Integer[]{now_x, now_y});
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isInRagne(int now_x, int now_y) {
        return now_x >= 0 && now_x < n && now_y >= 0 && now_y < m;
    }
}

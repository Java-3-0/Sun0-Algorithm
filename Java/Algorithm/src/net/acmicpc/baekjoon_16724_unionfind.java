/***
 * 	108888kb
 * 	408ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16724_unionfind {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for (int j = 0; j < m; j++) {
                switch (str.charAt(j)) {
                    case 'U':
                        arr[i][j] = 3;
                        break;
                    case 'D':
                        arr[i][j] = 1;
                        break;
                    case 'L':
                        arr[i][j] = 2;
                        break;
                    case 'R':
                        arr[i][j] = 0;
                        break;
                }
            }
        }
        int index = 1;

        parent = new int[n * m + 1];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    Queue<int[]> que = new LinkedList<>();
                    visited[i][j] = index;
                    parent[index] = index;
                    que.offer(new int[]{i, j});

                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        int nowX = now[0] + dx[arr[now[0]][now[1]]];
                        int nowY = now[1] + dy[arr[now[0]][now[1]]];
                        if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m) {
                            if (visited[nowX][nowY] == 0) { // 가려는 방향이 아직 가지 않은 곳일때
                                visited[nowX][nowY] = index;
                                que.offer(new int[]{nowX, nowY});
                            } else { // 만약 간 방향이면 index랑 만나는 곳 부모 합쳐줘~
                                union(index, visited[nowX][nowY]);
                            }
                        }
                    }
                    index++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (i == parent[i])
                count++;
        }
        System.out.println(count - 1);
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return;
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
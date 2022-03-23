//46016kb,	304ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_17142 {
    public static int[][] arr;
    public static boolean[] isUsedVirus = new boolean[10];
    public static int virus_count;
    public static int novirus_count;
    public static int[][] virus;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n, m;
    public static int minnum = Integer.MAX_VALUE;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        virus = new int[10][2];
        virus_count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus[virus_count][0] = i;
                    virus[virus_count++][1] = j;
                } else if (arr[i][j] == 0)
                    novirus_count++;
            }
        }

        Combination(0, 0);
        System.out.println(minnum != Integer.MAX_VALUE ? minnum : -1);

    }

    private static void Combination(int i, int cnt) {
        if (cnt == m) {
            int maxnum = GoVirus();
            if (maxnum != -1) {
                minnum = Math.min(minnum, maxnum);
            }
            return;
        }
        if (i >= virus_count) return;
        isUsedVirus[i] = true;
        Combination(i + 1, cnt + 1);
        isUsedVirus[i] = false;
        Combination(i + 1, cnt);
    }

    private static int GoVirus() {
        int cnt = 0;
        int maxnum = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer[]> que = new LinkedList<>();
        for (int i = 0; i < virus_count; i++) {
            if (isUsedVirus[i]) {
                que.offer(new Integer[]{virus[i][0], virus[i][1], 0});
                visited[virus[i][0]][virus[i][1]] = true;
            }
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Integer[] now = que.poll();
                if (arr[now[0]][now[1]] == 0) {
                    cnt++;
                    maxnum = Math.max(maxnum, now[2]);
                }
                visited[now[0]][now[1]] = true;

                for (int k = 0; k < 4; k++) {
                    int now_x = now[0] + dx[k];
                    int now_y = now[1] + dy[k];
                    if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < n && !visited[now_x][now_y] && (arr[now_x][now_y] == 0 || arr[now_x][now_y] == 2)) {
                        que.offer(new Integer[]{now_x, now_y, now[2] + 1});
                        visited[now_x][now_y] = true;
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }
//        System.out.println(cnt + " " + novirus_count);
//        if (cnt == novirus_count)
//            System.out.println(maxnum);
//        else
//            System.out.println("-1");
//        System.out.println("******");
        if (cnt == novirus_count) return maxnum == Integer.MIN_VALUE ? 0 : maxnum;
        else return -1;
    }
}

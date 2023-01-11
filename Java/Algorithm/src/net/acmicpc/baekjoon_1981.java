/***
 * 48768kb
 * 540ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class baekjoon_1981 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minNum = Integer.MAX_VALUE;
        int nowMin = 0;

        for (int i = 0; i <= board[0][0]; i++) {
            nowMin = i;
            PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return board[o1[0]][o1[1]] - board[o2[0]][o2[1]];
                }
            });
            boolean[][] visited = new boolean[n][n];
            boolean isFinish = false;
            int nowMax = 0;
            que.offer(new int[]{0, 0});
            visited[0][0] = true;
            while (!que.isEmpty()) {
                int[] now = que.poll();
                int x = now[0];
                int y = now[1];
                int nowNum = board[x][y];
                nowMax = Math.max(nowMax, nowNum);
                if (x == n - 1 && y == n - 1) {
                    isFinish = true;
                    break;
                }


                for (int j = 0; j < 4; j++) {
                    int nowX = x + dx[j];
                    int nowY = y + dy[j];
                    if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n && !visited[nowX][nowY] && board[nowX][nowY] >= nowMin) {
                        que.offer(new int[]{nowX, nowY});
                        visited[nowX][nowY] = true;
                    }
                }
            }
            if (isFinish) {
//                System.out.println("nowMax: " + nowMax + ", nowMin: " + nowMin);
                minNum = Math.min(minNum, nowMax - nowMin);
            }

        }
        System.out.println(minNum);
    }
}

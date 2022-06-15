/***
 * 61700kb
 * 412ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_4991 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    private static int[][] clean;
    private static int cleanCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            char[][] arr = new char[h][];
            for (int i = 0; i < h; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            int start_x = 0;
            int start_y = 0;
            clean = new int[10][2];
            cleanCnt = 0;
            int length = 0;
            int answer = -1;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == '*') {
                        clean[cleanCnt][0] = i;
                        clean[cleanCnt][1] = j;
                        cleanCnt++;
                    } else if (arr[i][j] == 'o') {
                        start_x = i;
                        start_y = j;
                    }
                }
            }

            boolean[][][] visited = new boolean[h][w][1 << 10];

            Queue<int[]> que = new ArrayDeque<>();
            que.offer(new int[]{start_x, start_y, 0});
            visited[start_x][start_y][0] = true;

            all:
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    int[] now = que.poll();
                    int x = now[0];
                    int y = now[1];
                    int nowLength = now[2];

                    if (nowLength == (1 << cleanCnt) - 1) {
                        answer = length;
                        break all;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nowX = x + dx[j];
                        int nowY = y + dy[j];
                        int nowVisited = nowLength;
                        if (nowX >= 0 && nowX < h && nowY >= 0 && nowY < w && arr[nowX][nowY] != 'x') {
                            if (arr[nowX][nowY] == '*') { //치워야 함
                                nowVisited |= (1 << getIndex(nowX, nowY));
                            }
                            if (!visited[nowX][nowY][nowVisited]) {
                                visited[nowX][nowY][nowVisited] = true;
                                que.offer(new int[]{nowX, nowY, nowVisited});
                            }
                        }
                    }
                }
                length++;
            }
            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }

    private static int getIndex(int nowX, int nowY) {
        for (int i = 0; i < cleanCnt; i++) {
            if (clean[i][0] == nowX && clean[i][1] == nowY) return i;
        }
        return -1;
    }
}

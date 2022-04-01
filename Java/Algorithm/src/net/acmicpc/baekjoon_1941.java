/***
 * 	62560kb
 * 	376ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_1941 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    private static int cnt;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][];

        for (int i = 0; i < 5; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        cnt = 0;
        for (int i = 0; i < (1 << 25); i++) {
            if (Integer.bitCount(i) == 7) {
                if (isOK(i))
                    cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isOK(int i) {
        //System.out.println(Integer.toBinaryString(i));

        Queue<int[]> que = new LinkedList<>();
        int yCnt = 0;

        for (int j = 0; j < 25; j++) {
            int now = 1 << j;
            if ((i & now) > 0) { // 돌다가 연결되어 있는지 발견
                int x = 4 - (j / 5);
                int y = 4 - (j % 5);
                que.offer(new int[]{x, y});
                if (arr[x][y] == 'Y')
                    yCnt++;
                i = i ^ (1 << j);
                break;
            }
        }

        int cnt = 0;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            cnt++;
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nowX = x + dx[k];
                int nowY = y + dy[k];
                if (nowX >= 0 && nowX < 5 && nowY >= 0 && nowY < 5 && ((i & (1 << (24 - (nowX * 5 + nowY)))) > 0)) {
                    que.offer(new int[]{nowX, nowY});
                    if (arr[nowX][nowY] == 'Y')
                        yCnt++;
                    i = i ^ (1 << (24 - (nowX * 5 + nowY)));
                    if (yCnt > 3) return false;
                }
            }
        }
        return cnt == 7;
    }

}

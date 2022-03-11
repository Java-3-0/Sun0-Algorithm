//37032kb,308ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3109 {
    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {1, 1, 1};
    public static int cnt = 0, r, c, index = 0;
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][];

        for (int i = 0; i < r; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        for (int i = 0, j = 0; i < r; i++) {
            if (arr[i][j] == '.') {
                arr[i][j] = 'x';
                DFS(i, j);
            }
        }
        System.out.println(cnt);
    }

    private static boolean DFS(int i, int j) {
        if (j == c - 1) {
            cnt++;
            return true;
        }

        for (int k = 0; k < 3; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y < c && y >= 0 && arr[x][y] == '.') {
                arr[x][y] = 'x';
                if (DFS(x, y)) return true;
            }
        }
        return false;
    }
}

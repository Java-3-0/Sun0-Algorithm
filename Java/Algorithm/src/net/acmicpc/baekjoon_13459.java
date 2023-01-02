/***
 * 	129496kb
 * 	352ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_13459 {
    static Pos hole = null;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static char[][] board;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Pos redMarble = null, blueMarble = null;
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    hole = new Pos(i, j);
                else if (board[i][j] == 'R')
                    redMarble = new Pos(i, j);
                else if (board[i][j] == 'B')
                    blueMarble = new Pos(i, j);
            }
        }
        Queue<Pos[]> que = new ArrayDeque<>();
        que.offer(new Pos[]{redMarble, blueMarble});

        boolean successed = false;
        all:
        for (int i = 0; i < 10; i++) {
            int size = que.size();
            for (int j = 0; j < size; j++) {
                Pos[] now = que.poll();
                Pos nowRed = now[0];
                Pos nowBlue = now[1];
                for (int k = 0; k < 4; k++) {
                    Pos movedRed = nowRed.move(k);
                    Pos movedBlue = nowBlue.move(k);
                    if (movedBlue.goal()) continue;
                    if (movedRed.goal()) {
                        successed = true;
                        break all;
                    }
                    if (movedRed.equals(movedBlue)) {
                        if (movedRed.cnt > movedBlue.cnt)
                            movedRed.back(k);
                        else
                            movedBlue.back(k);
                    }

                    que.offer(new Pos[]{movedRed, movedBlue});
                }
            }
        }
        System.out.println(successed ? '1' : '0');


    }

    static class Pos {
        int x, y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        public boolean goal() {
            return this.x == hole.x && this.y == hole.y;
        }

        public Pos move(int dir) {
            int nx = this.x;
            int ny = this.y;
            int cnt = 0;

            while (board[nx + dx[dir]][ny + dy[dir]] != '#') {
                nx += dx[dir];
                ny += dy[dir];
                cnt += 1;
                if (board[nx][ny] == 'O')
                    return new Pos(nx, ny, cnt);
            }
            return new Pos(nx, ny, cnt);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pos)) return false;

            Pos pos = (Pos) o;

            if (x != pos.x) return false;
            return y == pos.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public void back(int dir) {
            this.x -= dx[dir];
            this.y -= dy[dir];
        }
    }
}

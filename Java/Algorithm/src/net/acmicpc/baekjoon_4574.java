/***
 * 13880kb
 * 104ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class baekjoon_4574 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][] board;
    private static boolean[][][] box;
    private static boolean[][] row, column;
    private static boolean[][] tileSet;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        int n, puzzleCnt = 1;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while ((n = Integer.parseInt(bf.readLine())) != 0) {
            board = new int[9][9];
            box = new boolean[3][3][9];
            row = new boolean[9][9];
            column = new boolean[9][9];
            tileSet = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                tileSet[i][i] = true;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                String lu = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                String lv = st.nextToken();
                useTile(u, v);
                useNumber(u, lu);
                useNumber(v, lv);
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i < 10; i++) {
                useNumber(i, st.nextToken());
            }
            int cnt = 81 - 9 - 2 * n;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == 0) {
                        solveSudoku(i, j, cnt);
                    }
                }
            }
            sb.append("Puzzle ").append(puzzleCnt).append("\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            puzzleCnt++;
        }
        System.out.println(sb);
    }

    private static boolean solveSudoku(int x1, int y1, int cnt) {
        for (int i = 0; i < 4; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            if (inRange(x2, y2) && isBlank(x2, y2)) {
                for (int j = 1; j < 10; j++) {
                    if (!canPut(x1, y1, j)) { // 1번째 자리에 둘 수 있으며
                        for (int k = 1; k < 10; k++) {
                            if (!tileSet[j - 1][k - 1] && !canPut(x2, y2, k)) { // 타일이 있고 타일도 놓을 수 있으면
                                putNumberOnBoard(x1, y1, j);
                                putNumberOnBoard(x2, y2, k);
                                useTile(j, k);
                                if (cnt == 2) return true;
                                aa:
                                for (int l = x1; l < 9; l++) {
                                    for (int m = 0; m < 9; m++) {
                                        if (board[l][m] == 0) {
                                            if (solveSudoku(l, m, cnt - 2))
                                                return true;
                                            else
                                                break aa;
                                        }
                                    }
                                }
                                putNumberOffBoard(x1, y1, j);
                                putNumberOffBoard(x2, y2, k);
                                unUseTile(j, k);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void putNumberOffBoard(int x, int y, int num) {
        board[x][y] = 0;
        row[x][num - 1] = false;
        column[y][num - 1] = false;
        box[x / 3][y / 3][num - 1] = false;
    }

    private static void unUseTile(int u, int v) {
        tileSet[u - 1][v - 1] = false;
        tileSet[v - 1][u - 1] = false;
    }

    private static boolean canPut(int x, int y, int num) {
        return row[x][num - 1] || column[y][num - 1] || box[x / 3][y / 3][num - 1];
    }


    private static boolean isBlank(int x, int y) {
        return board[x][y] == 0;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    private static void useNumber(int num, String location) {
        int x = location.charAt(0) - 'A';
        int y = location.charAt(1) - '1';
        putNumberOnBoard(x, y, num);
    }

    private static void putNumberOnBoard(int x, int y, int num) {
        board[x][y] = num;
        row[x][num - 1] = true;
        column[y][num - 1] = true;
        box[x / 3][y / 3][num - 1] = true;
    }

    private static void useTile(int u, int v) {
        tileSet[u - 1][v - 1] = true;
        tileSet[v - 1][u - 1] = true;
    }

}

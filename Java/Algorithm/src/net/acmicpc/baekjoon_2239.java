/***
 * 16104kb
 * 388ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2239 {

    private static boolean[][][] box;
    private static boolean[][] row;
    private static boolean[][] column;
    private static int[][] arr;
    private static int lastX, lastY;
    private static boolean flg;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        box = new boolean[3][3][9];// 해당 박스에 해당 숫자가 있는지
        row = new boolean[9][9];// i번째 row에 해당 숫자가 있는지
        column = new boolean[9][9];
        arr = new int[9][9];
        flg = false;

        for (int i = 0; i < 9; i++) {
            char[] temp = bf.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = temp[j] - '0';
                if (arr[i][j] != 0) {
                    box[i / 3][j / 3][arr[i][j] - 1] = true;
                    row[i][arr[i][j] - 1] = true;
                    column[j][arr[i][j] - 1] = true;
                } else {
                    lastX = i;
                    lastY = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0)
                    solve_the_sudoku(i, j);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean solve_the_sudoku(int x, int y) {


        for (int num = 1; num <= 9; num++) { // 1부터 9까지 그 자리에 들어갈 수 있는애 넣기
            if (!row[x][num - 1] && !column[y][num - 1] && !box[x / 3][y / 3][num - 1]) {
                arr[x][y] = num;
                row[x][num - 1] = true;
                column[y][num - 1] = true;
                box[x / 3][y / 3][num - 1] = true;
                if (x == lastX && y == lastY) {
                    return true;
                }
                aa:
                for (int i = x; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (arr[i][j] == 0) {
                            if (solve_the_sudoku(i, j))
                                return true;
                            else
                                break aa;
                        }
                    }
                }
                arr[x][y] = 0;
                row[x][num - 1] = false;
                column[y][num - 1] = false;
                box[x / 3][y / 3][num - 1] = false;
            }
        }
        return false;
    }
}

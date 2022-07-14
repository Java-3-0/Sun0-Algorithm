/***
 * 13172kb
 * 108ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_16918 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] originArr = new char[r][];
        char[][] switchedArr = new char[r][c];
        char[][] switchedArr2 = new char[r][c];
        char[][] voidArr = new char[r][c];
        for (int i = 0; i < r; i++) {
            originArr[i] = bf.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                switchedArr[i][j] = 'O';
                switchedArr2[i][j] = 'O';
                voidArr[i][j] = 'O';
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (originArr[i][j] == 'O') {
                    switchedArr[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < r && y >= 0 && y < c) {
                            switchedArr[x][y] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (switchedArr[i][j] == 'O') {
                    switchedArr2[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < r && y >= 0 && y < c) {
                            switchedArr2[x][y] = '.';
                        }
                    }
                }
            }
        }

        char[][] answerArr;
        if (n % 2 == 0)
            answerArr = voidArr;
        else if (n == 1)
            answerArr = originArr;
        else if ((n - 3) % 4 == 0)
            answerArr = switchedArr;
        else
            answerArr = switchedArr2;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(answerArr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

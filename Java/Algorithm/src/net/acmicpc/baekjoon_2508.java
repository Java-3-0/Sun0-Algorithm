//19040kb	188ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2508 {

    private static int n;
    private static int m;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(bf.readLine());
        for (int t = 0; t < test_case; t++) {
            bf.readLine();
            int cnt = 0;
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == '>' && checkrow(i, j))
                        cnt++;
                    else if (arr[i][j] == 'v' && checkcol(i, j))
                        cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    private static boolean checkcol(int x, int y) {
        int x1 = x;
        int x2 = x + 1;
        int x3 = x + 2;
        if (x1 >= n || x2 >= n || x3 >= n) return false;
        if (arr[x1][y] == 'v' && arr[x2][y] == 'o' && arr[x3][y] == '^') {
            arr[x1][y] = '.';
            arr[x2][y] = '.';
            arr[x3][y] = '.';
            return true;
        }
        return false;
    }

    private static boolean checkrow(int x, int y) {
        int y1 = y;
        int y2 = y + 1;
        int y3 = y + 2;
        if (y1 >= m || y2 >= m || y3 >= m) return false;
        if (arr[x][y1] == '>' && arr[x][y2] == 'o' && arr[x][y3] == '<') {
            arr[x][y1] = '.';
            arr[x][y2] = '.';
            arr[x][y3] = '.';
            return true;
        }
        return false;
    }
}

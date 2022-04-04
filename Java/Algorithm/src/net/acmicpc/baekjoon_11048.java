/***
 * 76624kb
 * 408ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11048 {

    private static final int[] dx = {0, 1};
    private static final int[] dy = {1, 0};
    private static int[][] arr;
    private static int n;
    private static int m;
    private static int maxnum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            arr[i][0] += arr[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            arr[0][i] += arr[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] += Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        System.out.println(arr[n - 1][m - 1]);
    }

}

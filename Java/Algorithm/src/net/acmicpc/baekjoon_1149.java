/***
 * 12080kb
 * 96ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());

        int[][] house = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[3][n + 1];

        // 초기값
        dp[0][1] = house[0][0];
        dp[1][1] = house[0][1];
        dp[2][1] = house[0][2];

        for (int i = 2; i < n + 1; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + house[i - 1][0];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + house[i - 1][1];
            dp[2][i] = Math.min(dp[1][i - 1], dp[0][i - 1]) + house[i - 1][2];
        }
        System.out.println(getMin(dp[0][n], dp[1][n], dp[2][n]));
    }

    private static int getMin(int a, int b, int c) {
        int num = Math.min(a, b);
        return Math.min(num, c);
    }
}

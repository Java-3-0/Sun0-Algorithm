/***
 * 12076kb
 * 88ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_17404 {
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

        int[][][] dp = new int[3][3][n + 1];

        // 초기값
        // [r로 시작][r:0.g:1,b:2][n개 선택]
        dp[0][0][1] = house[0][0];
        dp[0][1][1] = 1000001;
        dp[0][2][1] = 1000001;

        dp[1][0][1] = 1000001;
        dp[1][1][1] = house[0][1];
        dp[1][2][1] = 1000001;

        dp[2][0][1] = 1000001;
        dp[2][1][1] = 1000001;
        dp[2][2][1] = house[0][2];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][0][i] = Math.min(dp[j][1][i - 1], dp[j][2][i - 1]) + house[i - 1][0];
                dp[j][1][i] = Math.min(dp[j][0][i - 1], dp[j][2][i - 1]) + house[i - 1][1];
                dp[j][2][i] = Math.min(dp[j][1][i - 1], dp[j][0][i - 1]) + house[i - 1][2];
            }
        }

        // n번째 처리
        // [r로 시작][n-1:r][n번째]
        dp[0][1][n] = Math.min(dp[0][0][n - 1], dp[0][2][n - 1]) + house[n - 1][1];
        dp[0][2][n] = Math.min(dp[0][1][n - 1], dp[0][0][n - 1]) + house[n - 1][2];

        dp[1][0][n] = Math.min(dp[1][1][n - 1], dp[1][2][n - 1]) + house[n - 1][0];
        dp[1][2][n] = Math.min(dp[1][1][n - 1], dp[1][0][n - 1]) + house[n - 1][2];

        dp[2][0][n] = Math.min(dp[2][1][n - 1], dp[2][2][n - 1]) + house[n - 1][0];
        dp[2][1][n] = Math.min(dp[2][0][n - 1], dp[2][2][n - 1]) + house[n - 1][1];

        System.out.println(getMin(dp[0][1][n], dp[0][2][n], dp[1][0][n], dp[1][2][n], dp[2][0][n], dp[2][1][n]));
    }

    private static int getMin(int a, int b, int c, int d, int e, int f) {
        int num = Math.min(a, b);
        int num1 = Math.min(c, d);
        int num2 = Math.min(e, f);
        int num3 = Math.min(num, num1);
        return Math.min(num2, num3);
    }
}

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(bf.readLine());

            int[][] arr = new int[2][n];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = Math.max(arr[1][0] + arr[0][1], arr[0][0]);

            for (int i = 2; i < n; i++) {
                dp[1][i - 1] = Math.max(dp[1][i - 2], dp[0][i - 2] + arr[1][i - 1]);
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[0][i]);
            }
            dp[1][n - 1] = Math.max(dp[1][n - 2], dp[0][n - 2] + arr[1][n - 1]);
            
            sb.append(dp[1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}

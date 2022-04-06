/***
 * 	11456kb
 * 	76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] stair = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            stair[i] = Integer.parseInt(bf.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = stair[1];
        if (n > 1)
            dp[2] = dp[1] + stair[2];

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }
        System.out.println(dp[n]);
    }

    private static int getMax(int a, int b, int c) {
        int num = Math.max(a, b);
        return Math.max(num, c);
    }
}

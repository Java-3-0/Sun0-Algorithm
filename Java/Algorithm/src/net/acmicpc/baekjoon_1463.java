// 15684kb, 112ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 0;
        if (n > 1) dp[2] = 1;
        if (n > 2) dp[3] = 1;
        for (int i = 4; i < n + 1; i++) {
            int num1 = i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE;
            int num2 = i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE;
            int num3 = dp[i - 1] + 1;
            dp[i] = getMinnum(num1, num2, num3);
        }
        System.out.println(dp[n]);

    }

    private static int getMinnum(int num1, int num2, int num3) {
        int num = Math.min(num1, num2);
        return Math.min(num, num3);
    }

}

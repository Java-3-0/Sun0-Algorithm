/***
 * 	19908kb
 * 	112ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[n + 1];
        int[] operation = new int[n + 1];
        dp[1] = 0;

        if (n > 1) {
            dp[2] = 1;
            operation[2] = 2;
        }
        if (n > 2) {
            dp[3] = 1;
            operation[3] = 3;
        }
        for (int i = 4; i < n + 1; i++) {
            int num1 = i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE;
            int num2 = i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE;
            int num3 = dp[i - 1] + 1;

            int num = Math.min(num3, Math.min(num1, num2));
            if (num == num1)
                operation[i] = 3;
            else if (num == num2)
                operation[i] = 2;
            else
                operation[i] = 1;
            dp[i] = num;
        }
        // System.out.println(Arrays.toString(dp));
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        int num = dp[n];
        while (n > 0) {
            sb.append(n).append(" ");
            if (operation[n] == 1)
                n -= 1;
            else if (operation[n] == 2)
                n /= 2;
            else
                n /= 3;
        }

        System.out.println(sb);
    }

}

/***
 * 11516kb
 * 96ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[][] dp = new long[10][n + 1];
        for (int i = 1; i < 10; i++) {
            dp[i][1] = 1;
        }
        if (n > 1) {
            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    int num = 0;
                    if (j - 1 >= 0)
                        num += dp[j - 1][i - 1];
                    if (j + 1 <= 9)
                        num += dp[j + 1][i - 1];
                    dp[j][i] = num % 1000000000;
                }
            }
        }
        long num = 0;
        for (int i = 0; i < 10; i++) {
            num += dp[i][n];
        }
        System.out.println(num % 1000000000);
    }
}

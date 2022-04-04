/***
 * 13060kb
 * 112ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] grape = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            grape[i] = Integer.parseInt(bf.readLine());
        }
        int[] dp = new int[n + 1];

        dp[1] = grape[1];
        if (n > 1)
            dp[2] = grape[1] + grape[2];
        if (n > 2)
            dp[3] = getMax(grape[1] + grape[3], grape[2] + grape[3], dp[2]);

        for (int i = 4; i < n + 1; i++) {
            // 현재값 = Max( oox, oxo, xoo)
            dp[i] = getMax(dp[i - 1], dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]);
        }
        System.out.println(dp[n]);
    }

    private static int getMax(int a, int b, int c) {
        int num = Math.max(a, b);
        return Math.max(num, c);
    }
}

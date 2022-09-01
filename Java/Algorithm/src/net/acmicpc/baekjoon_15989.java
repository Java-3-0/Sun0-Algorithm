/***
 * 11716kb
 * 80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[10002];
        Arrays.fill(dp, 1);
        for (int i = 2; i < 10002; i++) {
            dp[i] += dp[i - 2];
        }
        for (int i = 3; i < 10002; i++) {
            dp[i] += dp[i - 3];
        }
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb);
    }

}

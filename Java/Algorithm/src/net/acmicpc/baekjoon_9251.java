/***
 * 15988kb
 * 104ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] ch1 = bf.readLine().toCharArray();
        char[] ch2 = bf.readLine().toCharArray();

        int[][] dp = new int[ch2.length + 1][ch1.length + 1];

        for (int i = 0; i < ch2.length; i++) {
            for (int j = 0; j < ch1.length; j++) {
                if (ch1[j] == ch2[i])
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        System.out.println(dp[ch2.length][ch1.length]);
    }
}

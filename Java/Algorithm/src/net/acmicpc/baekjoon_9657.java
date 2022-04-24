/***
 * 	11524kb
 * 	84ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boolean[] dp = new boolean[n + 1];

        dp[1] = true;
        if (n > 1) dp[2] = false;
        if (n > 2) dp[3] = true;
        if (n > 3) dp[4] = true;


        for (int i = 5; i < n + 1; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }

        if (dp[n])
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}

/***
 * 12672kb
 * 136ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2758 {

    private static int n;
    private static int m;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        dp = new long[11][2001]; //[depth][number]
        InitializeArray();

        int test_case = Integer.parseInt(bf.readLine());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            topdown(n, m);
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }

    private static void InitializeArray() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2001; j++) {
                dp[i][j] = -1;
            }
        }
    }

    private static long topdown(int depth, int num) {

        if (dp[depth][num] != -1) return dp[depth][num];

        if (depth == 1) {
            return dp[depth][num] = num;
        }

        long sum = 0;
        for (int i = num; i >= Math.pow(2, depth - 1); i--) {
            sum += topdown(depth - 1, i / 2);
        }
        return dp[depth][num] = sum;
    }
}

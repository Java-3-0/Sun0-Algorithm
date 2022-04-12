/***
 * 22144kb
 * 136ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class baekjoon_1562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[][][] dp = new long[1024][10][n + 1];
        HashSet<Integer>[] set = new HashSet[10];
        set[0] = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            dp[1 << i][i][1] = 1;
            set[i] = new HashSet<>();
            set[i].add(1 << i);
        }
        if (n > 1) {
            for (int i = 2; i < n + 1; i++) {
                HashSet<Integer>[] nowSet = new HashSet[10];
                for (int j = 0; j < 10; j++) {
                    nowSet[j] = new HashSet<>();
                    if (j - 1 >= 0) {
                        for (Integer loc : set[j - 1]) {
                            int now = loc | (1 << j);
                            dp[now][j][i] += dp[loc][j - 1][i - 1] % 1000000000;
                            nowSet[j].add(now);
                        }
                    }
                    if (j + 1 <= 9) {
                        for (Integer loc : set[j + 1]) {
                            int now = loc | (1 << j);
                            dp[now][j][i] += dp[loc][j + 1][i - 1] % 1000000000;
                            nowSet[j].add(now);
                        }
                    }
                }
                set = nowSet;
            }
        }
        long num = 0;
        for (int i = 0; i < 10; i++) {
            num += dp[1023][i][n];
        }
        System.out.println(num % 1000000000);
    }
}
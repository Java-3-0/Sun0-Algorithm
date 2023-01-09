/***
 * 14816kb
 * 324ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class baekjoon_26607 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] member = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            member[i][0] = Integer.parseInt(st.nextToken());
            member[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isPossible = new boolean[k + 1][k * x + 1];
        isPossible[0][0] = true;

        for (int i = 0; i < n; i++) {
            int now = member[i][0];
            for (int j = k; j > 0; j--) {
                for (int l = 0; l < k * x + 1; l++) {
                    if (isPossible[j - 1][l]) {
                        isPossible[j][l + now] = true;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < k * x + 1; i++) {
            if (isPossible[k][i]) {
                answer = Math.max(answer, i * (k * x - i));
            }
        }
        System.out.println(answer);
    }
}

package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[][] edge = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    edge[i][j] = Integer.parseInt(st.nextToken());
                    if (edge[i][j] == 0) {
                        edge[i][j] = 10000;
                    }
                }
            }

            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    if (i == k) continue;
                    for (int j = 0; j < n; ++j) {
                        if (i == j || k == j) continue;
                        if (edge[i][j] > edge[i][k] + edge[k][j]) {
                            edge[i][j] = edge[i][k] + edge[k][j];
                        }
                    }
                }
            }
            int minnum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    cnt += edge[i][j];
                }
                minnum = Math.min(minnum, cnt);
            }
            sb.append("#").append(t).append(" ").append(minnum).append("\n");
        }
        System.out.println(sb);
    }
}

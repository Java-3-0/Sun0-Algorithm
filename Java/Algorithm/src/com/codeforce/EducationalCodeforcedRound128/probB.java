package com.codeforce.EducationalCodeforcedRound128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class probB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int left = m;
            int top = n;
            int topJ = m;
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 'R') {
                        if (i < top && j < topJ) {
                            top = i;
                            topJ = j;
                        }
                        if (j < left) left = j;
                    }
                }
            }
            if (topJ > left)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }
        System.out.println(sb);
    }
}

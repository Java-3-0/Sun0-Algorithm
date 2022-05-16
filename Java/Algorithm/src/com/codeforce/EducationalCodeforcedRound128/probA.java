package com.codeforce.EducationalCodeforcedRound128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class probA {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int l1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            boolean flg = true;
            for (int j = l1; j <= r1; j++) {
                if (j >= l2 && j <= r2) {
                    sb.append(j).append("\n");
                    flg = false;
                    break;
                }
            }
            if (flg) {
                sb.append(l1 + l2).append("\n");
            }
        }

        System.out.println(sb);
    }
}

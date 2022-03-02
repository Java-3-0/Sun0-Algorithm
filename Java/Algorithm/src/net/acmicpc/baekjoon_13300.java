// 11976kb,92ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cnt = new int[6][m];
        int room = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            cnt[grade - 1][gender]++;
            if (cnt[grade - 1][gender] == m) {
                cnt[grade - 1][gender] = 0;
                room++;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (cnt[i][j] != 0) room++;
            }
        }
        System.out.println(room);
    }
}

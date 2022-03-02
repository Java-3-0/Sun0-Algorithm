//19956kb,232ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[1001][1001];

        int n = Integer.parseInt(bf.readLine());
        int[] cnt = new int[n];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x1 + width; j++) {
                for (int k = y1; k < y1 + height; k++) {
                    arr[j][k] = i;
                }
            }
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (arr[i][j] == 0) continue;
                else cnt[arr[i][j] - 1]++;
            }
        }

        for (int a : cnt) {
            System.out.println(a);
        }
    }
}

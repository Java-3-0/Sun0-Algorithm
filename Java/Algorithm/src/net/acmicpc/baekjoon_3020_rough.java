package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3020_rough {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] height = new int[h];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (i % 2 == 0) {
                for (int j = h - 1; j > h - 1 - num; j--) {
                    height[j]++;
                }
            } else {
                for (int j = 0; j < num; j++) {
                    height[j]++;
                }
            }
        }
        int minnum = Integer.MAX_VALUE;
        int mincnt = 0;
        for (int i = 0; i < h; i++) {
            if (minnum > height[i]) {
                minnum = height[i];
                mincnt = 1;
            } else if (minnum == height[i])
                mincnt++;
        }
        System.out.println(minnum + " " + mincnt);
    }
}

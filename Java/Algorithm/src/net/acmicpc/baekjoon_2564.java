//11572kb,80ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2564 {
    private static int width, height;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(bf.readLine());
        int[] coordinate = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int xory = Integer.parseInt(st.nextToken());
            coordinate[i] = CoordinateToNum(dir, xory);
        }
        st = new StringTokenizer(bf.readLine());
        int mydir = Integer.parseInt(st.nextToken());
        int myxory = CoordinateToNum(mydir, Integer.parseInt(st.nextToken()));

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += Math.min(Math.abs(myxory - coordinate[i]), 2 * height + 2 * width - Math.abs(myxory - coordinate[i]));
        }
        System.out.println(cnt);
    }

    private static int CoordinateToNum(int dir, int xory) {
        switch (dir) {
            case 1:
                return xory;
            case 2:
                return 2 * width + height - xory;
            case 3:
                return 2 * width + 2 * height - xory;
            case 4:
                return width + xory;
        }
        return 0;
    }


}

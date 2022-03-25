//	32784kb	492ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_3020_fast {

    private static int n, h;
    private static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        length = n / 2;

        int[] down = new int[n / 2];
        int[] up = new int[n / 2];

        int downIndex = 0, upIndex = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (i % 2 == 0) {
                up[upIndex++] = num;
            } else {
                down[downIndex++] = num;
            }
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int minnum = Integer.MAX_VALUE;
        int mincnt = 0;

        for (int i = 1; i <= h; i++) {
            int now = 0;
            int indexUp = binarysearch(up, i);
            if (indexUp != -1)
                now += length - indexUp; // 나를 포함한 갯수

            int indexDown = binarysearch(down, h - i + 1);
            if (indexDown != -1)
                now += length - indexDown;

            if (minnum > now) {
                minnum = now;
                mincnt = 1;
            } else if (minnum == now)
                mincnt++;
        }


        System.out.println(minnum + " " + mincnt);
    }

    private static int binarysearch(int[] arr, int targetNum) {
        int l = 0;
        int r = length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < targetNum) {
                l = mid + 1;
            } else if (arr[mid] >= targetNum) {
                r = mid;
            }
        }
        if (l == length) return -1;
        return r;
    }
}

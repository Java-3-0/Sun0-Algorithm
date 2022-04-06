/***
 * 18196kb
 * 244ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        int[][] line = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> (o1[0] - o2[0]));

        int[] lis = new int[n];
        Arrays.fill(lis, 1000);

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(lis, line[i][1]);
            maxIndex = Math.max(maxIndex, index);
            lis[index] = line[i][1];
        }
        System.out.println(n - (maxIndex + 1));
    }

    private static int binarySearch(int[] lis, int i) {
        int l = 0;
        int r = lis.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (lis[mid] > i)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }
}

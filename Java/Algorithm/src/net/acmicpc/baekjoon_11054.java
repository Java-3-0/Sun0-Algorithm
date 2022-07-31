/***
 * 	11840kb
 * 	88ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11054 {

    private static final int INF = Integer.MAX_VALUE;
    private static int n;
    private static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        length = new int[n];
        Arrays.fill(length, INF);

        int[] order = new int[n];
        int[] reverseOrder = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            order[i] = setLocation(arr[i]);
        }
        Arrays.fill(length, INF);

        for (int i = n - 1; i >= 0; i--) {
            reverseOrder[i] = setLocation(arr[i]);
        }
//
//        System.out.println(Arrays.toString(order));
//        System.out.println(Arrays.toString(reverseOrder));
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, order[i] + reverseOrder[i] - 1);
        }
        System.out.println(max);
    }

    private static int setLocation(int now) {
        int l = 0;
        int r = n;

        while (l < r) {
            int mid = (l + r) / 2;
            if (length[mid] >= now)
                r = mid;
            else
                l = mid + 1;
        }
        length[l] = now;
        return l + 1;
    }
}

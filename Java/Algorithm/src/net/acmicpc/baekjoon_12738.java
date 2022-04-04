/***
 * 	170524kb
 * 	548ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_12738 {

    private static final int INF = Integer.MAX_VALUE;
    private static int[] length;
    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        arr = new int[n];
        length = new int[n];

        // 길이배열 초기화
        Arrays.fill(length, INF);

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            setLocation(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (length[i] == INF) {
                System.out.println(i);
                break;
            }
            if (i == n - 1) {
                System.out.println(i + 1);
            }
        }
    }

    private static void setLocation(int now) {
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
    }
}

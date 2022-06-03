/***
 * 22960kb
 * 216ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while (r < n) {
            if (sum < s) {
                sum += arr[r++];
            } else {
                length = Math.min(length, r - l);
                sum -= arr[l++];
            }
        }
        while (sum >= s) {
            length = Math.min(length, r - l);
            sum -= arr[l++];
        }

        if (length == Integer.MAX_VALUE)
            length = 0;
        System.out.println(length);
    }
}

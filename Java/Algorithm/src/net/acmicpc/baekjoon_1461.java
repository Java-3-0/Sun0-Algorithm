/***
 * 11624kb
 * 76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n] = 0;

        Arrays.sort(arr);

        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            if (arr[i] == 0) {
                index = i;
                break;
            }
        }
        int l = 0;
        int r = n;
        int cnt = 0;

        while (l < index) {
            cnt += (Math.abs(arr[l]) * 2);
            l += m;
        }
        while (r > index) {
            cnt += (Math.abs(arr[r]) * 2);
            r -= m;
        }

        if (Math.abs(arr[0]) < Math.abs(arr[n])) {
            cnt -= Math.abs(arr[n]);
        } else {
            cnt -= Math.abs(arr[0]);
        }

        System.out.println(cnt);
    }
}

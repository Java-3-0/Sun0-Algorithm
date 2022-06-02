/***
 * 332148kb
 * 2680ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a < b) {
                arr[i][0] = a;
                arr[i][1] = b;
            } else {
                arr[i][0] = b;
                arr[i][1] = a;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int s = arr[0][0];
        int e = arr[0][1];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int now_s = arr[i][0];
            int now_e = arr[i][1];

            if (e < now_s) {// s e now_s now_e
                cnt += (e - s);
                s = now_s;
                e = now_e;
            } else if (now_s >= s) { // s now_s e
                if (now_e > e) // s now_s e now_e
                    e = now_e;
            }

        }
        cnt += (e - s);
        System.out.println(cnt);
    }
}

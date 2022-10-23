/***
 * 12880kb
 * 92ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[] days = new int[366];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                days[j]++;
            }
        }
        int length = 0;
        int total = 0;
        int maxHeight = 0;
        for (int i = 0; i < 366; i++) {
            if (days[i] == 0) {
                if (length != 0) {
                    total += length * maxHeight;
                    length = 0;
                    maxHeight = 0;
                }
                continue;
            }
            length++;
            maxHeight = Math.max(maxHeight, days[i]);
        }
        if (length != 0)
            total += length * maxHeight;
        System.out.println(total);

    }
}

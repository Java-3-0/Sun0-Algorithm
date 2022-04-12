/***
 * 17776kb
 * 184ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[m + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= Math.sqrt(m + 1); i++) {
            for (int j = i * i; j < m + 1; j += i) {
                arr[j] = true;
            }
        }
        for (int i = n; i < m + 1; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}

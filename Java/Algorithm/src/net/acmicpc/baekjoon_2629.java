/***
 * 	12476kb
 * 	92ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[] choo = new int[n];
        boolean[] chooDP = new boolean[40001];
        chooDP[0] = true;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            choo[i] = Integer.parseInt(st.nextToken());
            for (int j = 15000; j >= 0; j--) {
                if (chooDP[j]) {
                    if (j + choo[i] < 15001)
                        chooDP[j + choo[i]] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15001; j++) {
                if (chooDP[j]) {
                    if (j - choo[i] >= 0)
                        chooDP[j - choo[i]] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            if (chooDP[Integer.parseInt(st.nextToken())])
                sb.append("Y ");
            else
                sb.append("N ");
        }
        System.out.println(sb);
    }
}

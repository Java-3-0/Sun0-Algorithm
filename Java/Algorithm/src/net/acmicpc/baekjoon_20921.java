/***
 * 12788kb
 * 120ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_20921 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        while (m > 0) {
            for (int i = n - 1; i > 0; i--) {
                if (arr[i] > arr[i - 1]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    m--;
                    if (m == 0) break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num :
                arr) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}

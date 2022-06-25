/***
 * 	32088kb
 * 	620ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 0; t < test_case; t++) {
            int n = Integer.parseInt(bf.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine();
            }
            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
            boolean flg = true;

            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    flg = false;
                    break;
                }

            }
            if (flg)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}

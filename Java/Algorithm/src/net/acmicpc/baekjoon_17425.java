/***
 * 41328kb
 * 408ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_17425 {

    private static long[] gx;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());
        int[] arr = new int[test_case];
        int maxNum = -1;
        for (int i = 0; i < test_case; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            maxNum = Math.max(maxNum, arr[i]);
        }

        gx = new long[maxNum + 1];

        for (int i = 1; i <= maxNum; i++) {
            for (int j = i; j <= maxNum; j += i) {
                gx[j] += i;
            }
        }
        for (int i = 1; i <= maxNum; i++) {
            gx[i] += gx[i - 1];
        }
        for (int i = 0; i < test_case; i++) {
            sb.append(gx[arr[i]]).append("\n");
        }
        System.out.println(sb);
    }


}

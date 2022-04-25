/***
 * 	14184kb
 * 	188ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2473 {

    private static long[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int mIndex = 0;
        int lIndex = 0;
        int rIndex = n - 1;
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (Math.abs(arr[l] + arr[r] + arr[i]) < minDiff) {
                    minDiff = Math.abs(arr[l] + arr[r] + arr[i]);
                    rIndex = r;
                    lIndex = l;
                    mIndex = i;
                }
                if (Math.abs(arr[l] + arr[r]) < Math.abs(arr[i]))
                    l++;
                else
                    r--;
            }
        }
        System.out.println(arr[mIndex] + " " + arr[lIndex] + " " + arr[rIndex]);
    }

}

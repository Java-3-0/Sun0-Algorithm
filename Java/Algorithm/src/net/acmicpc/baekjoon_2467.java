/***
 * 31280kb
 * 272ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2467 {

    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lIndex = 0;
        int rIndex = n - 1;
        int l = 0;
        int r = n - 1;
        int minDiff = Integer.MAX_VALUE;
        while (l < r) {
            if (Math.abs(arr[l] + arr[r]) < minDiff) {
                minDiff = Math.abs(arr[l] + arr[r]);
                rIndex = r;
                lIndex = l;
            }
            if (Math.abs(arr[l]) > Math.abs(arr[r]))
                l++;
            else
                r--;
        }
        System.out.println(arr[lIndex] + " " + arr[rIndex]);
    }

}

//21156kb,1476ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxcnt = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (num <= arr[j]) {
                    cnt++;
                    num = arr[j];
                } else
                    break;
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (num >= arr[j]) {
                    cnt++;
                    num = arr[j];
                } else
                    break;
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        System.out.println(maxcnt);
    }
}

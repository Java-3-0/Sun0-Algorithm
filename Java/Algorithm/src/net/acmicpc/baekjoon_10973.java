/***
 * 스트링빌더 버전
 * 13520kb
 * 116ms
 *
 * 	System.out
 * 	17676kb
 * 	296ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10973 {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = n - 1;
        while (i > 0 && arr[i - 1] < arr[i])
            i--;

        if (i <= 0)
            System.out.println("-1");
        else {
            int j = n - 1;
            while (arr[j] > arr[i - 1])
                j--;

            swap(i - 1, j);

            j = n - 1;
            while (i < j) {
                swap(i, j);
                i++;
                j--;
            }

            for (int k = 0; k < n; k++) {
                sb.append(arr[k]).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

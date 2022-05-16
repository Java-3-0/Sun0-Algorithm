/***
 * 69480kb
 * 960ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] arr = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                arr[i][j] = 500000000;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from - 1][to - 1] = weight;
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                if (i == k) continue;
                for (int j = 0; j < v; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }


        int num = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) continue;
                num = Math.min(num, arr[i][j] + arr[j][i]);
            }
        }

        System.out.println(num > 500000000 ? -1 : num);
    }
}

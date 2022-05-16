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
        int[][] distance = new int[v][v];
        int[][] arr = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distance[i][j] = 5000000;
                arr[i][j] = 5000000;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from - 1][to - 1] = weight;
            distance[from - 1][to - 1] = weight;
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (arr[i][k] == -1 || arr[k][j] == -1) continue;
                    if (arr[i][k] + arr[k][j] < distance[i][j])
                        distance[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }


        int num = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (distance[i][j] == -1 || distance[j][i] == -1)
                    continue;
                num = Math.min(num, distance[i][j] + distance[j][i]);
            }
        }

        System.out.println(num == Integer.MAX_VALUE ? -1 : num);
    }
}

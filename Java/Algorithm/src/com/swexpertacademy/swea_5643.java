package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5643 {

    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= test_case; t++) {
            n = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());
            visited = new boolean[n + 1];

            int cnt = 0;

            ArrayList<Integer>[] ascending = new ArrayList[n + 1];
            ArrayList<Integer>[] descending = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                ascending[i] = new ArrayList<Integer>();
                descending[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                ascending[from].add(to);
                descending[to].add(from);
            }

            for (int i = 1; i < n + 1; i++) {
                Arrays.fill(visited, false);
                visited[0] = true;
                visited[i] = true;
                find(i, ascending);
                find(i, descending);
                if (isFalseIn(i)) {
                    cnt++;
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isFalseIn(int i) {
        for (int j = 0; j < n + 1; j++) {
            if (!visited[j])
                return false;
        }
        return true;
    }

    private static void find(int i, ArrayList<Integer>[] list) {
        for (Integer next : list[i]) {
            if (!visited[next]) {
                visited[next] = true;
                find(next, list);
            }
        }
    }
}

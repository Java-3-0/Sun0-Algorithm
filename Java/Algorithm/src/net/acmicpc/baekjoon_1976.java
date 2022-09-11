/***
 * 	16828kb
 * 	152ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        boolean[][] city = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    city[i][j] = true;
            }
        }

        st = new StringTokenizer(bf.readLine());
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
            set.add(arr[i]);
        }

        boolean[] visited = new boolean[n];
        HashSet<Integer> visitedSet = new HashSet<>();
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(arr[0]);
        visitedSet.add(arr[0]);
        visited[arr[0]] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (visitedSet.containsAll(set)) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if (city[now][i] && !visited[i]) {
                    que.offer(i);
                    visitedSet.add(i);
                    visited[i] = true;
                }
            }
        }

        if (visitedSet.containsAll(set))
            System.out.println("YES");
        else
            System.out.println("NO");
    }


}

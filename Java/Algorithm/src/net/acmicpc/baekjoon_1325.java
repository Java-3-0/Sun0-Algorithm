/***
 * 	306336kb
 * 	9596ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1325 {

    private static int n;
    private static boolean[] visited;
    private static int cnt;
    private static int[] hackCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] linked = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            linked[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            linked[to].add(from);
        }

        hackCnt = new int[n];
        int maxHackCnt = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];

            Queue<Integer> que = new LinkedList<>();
            visited[i] = true;
            que.offer(i);

            while (!que.isEmpty()) {
                int now = que.poll();

                for (int to : linked[now]) {
                    if (!visited[to]) {
                        visited[to] = true;
                        que.offer(to);
                        hackCnt[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            maxHackCnt = Math.max(maxHackCnt, hackCnt[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (maxHackCnt == hackCnt[i])
                sb.append(i + 1).append(" ");
        }
        System.out.println(sb);
    }
}

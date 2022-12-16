package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1697 {

    private static Queue<int[]> que;
    private static boolean[] visited;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        que = new ArrayDeque<>();
        que.offer(new int[]{start, 0});
        visited[start] = true;

        while (!que.isEmpty()) {

            int[] now = que.poll();
            int pos = now[0];
            int count = now[1];
            if (pos == end) {
                System.out.println(count);
                break;
            }

            canInsertNextPosition(pos - 1, count);
            canInsertNextPosition(pos + 1, count);
            canInsertNextPosition(pos * 2, count);
        }
    }

    private static void canInsertNextPosition(int pos, int count) {
        if (pos >= 0 && pos < 100001 && !visited[pos]) {
            que.offer(new int[]{pos, count + 1});
            visited[pos] = true;
        }
    }
}

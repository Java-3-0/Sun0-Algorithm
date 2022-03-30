package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_3124 {

    private static int[] isFamily;
    private static int v;
    private static int e;
    private static PriorityQueue<Integer[]> edge;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(bf.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            isFamily = new int[v + 1];
            for (int i = 0; i < v + 1; i++) {
                isFamily[i] = i;
            }

            edge = new PriorityQueue<>(((o1, o2) -> (o1[2] - o2[2])));
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(bf.readLine());
                edge.offer(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())});
            }


            int cnt = 0;
            long totalWeight = 0;
            while (!edge.isEmpty()) {
                Integer[] now = edge.poll();
                int start = now[0];
                int end = now[1];
                int weight = now[2];
                if (union(start, end)) {
                    totalWeight += weight;
                    cnt++;
                    if (cnt == v - 1) break;
                }
            }
            sb.append("#" + t + " " + totalWeight + "\n");
        }
        System.out.println(sb);
    }

    private static boolean union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);

        if (aRoot == bRoot) return false;

        if (aRoot < bRoot)
            isFamily[bRoot] = aRoot;
        else
            isFamily[aRoot] = bRoot;
        return true;
    }

    private static int find(int start) {
        if (isFamily[start] == start) return start;
        return isFamily[start] = find(isFamily[start]);
    }
}

/***
 * 	50956kb
 * 	552ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1197 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        PriorityQueue<int[]> edges = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            edges.offer(new int[]{v1, v2, w});
        }

        int cnt = v - 1;
        long totalWeight = 0;
        while (cnt > 0 && !edges.isEmpty()) {
            int[] edge = edges.poll();
            int v1 = edge[0];
            int v2 = edge[1];
            int w = edge[2];
            if (union(v1, v2)) {
                totalWeight += w;
                cnt--;
            }
        }
        System.out.println(totalWeight);
    }

    private static boolean union(int v1, int v2) {
        int v1sMom = find(v1);
        int v2sMom = find(v2);
        if (v1sMom == v2sMom)
            return false;
        else {
            parent[v2sMom] = v1sMom;
            return true;
        }
    }

    private static int find(int v1) {
        if (v1 == parent[v1]) return v1;
        else return parent[v1] = find(parent[v1]);
    }
}

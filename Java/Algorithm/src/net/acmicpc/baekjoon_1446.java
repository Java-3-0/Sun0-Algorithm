//18344kb,236ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer>[] map = new HashMap[d + 1];
        int[] road = new int[d + 1];

        for (int i = 0; i < d + 1; i++) {
            road[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (start > d) continue;
            if (map[start] == null) {
                map[start] = new HashMap<>();
            }
            if (map[start].getOrDefault(end, Integer.MAX_VALUE) > weight) {
                map[start].put(end, weight);
            }
        }

        PriorityQueue<int[]> que = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        que.offer(new int[]{0, 0});
        road[0] = 0;
        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int start = poll[0];
            int weight = poll[1];

            // 지금까지 온 거리가 기록 거리보다 더 무거우면 컨티뉴
            if (road[start] < weight && start > d) continue;

            if (map[start] != null) {
                for (Integer dest : map[start].keySet()
                ) {
                    if (dest > d) continue;
                    if (map[start].get(dest) + road[start] < road[dest]) {
                        road[dest] = map[start].get(dest) + road[start];
                        que.offer(new int[]{dest, road[dest]});
                    }
                }
            }
            int dest = start + 1;
            if (dest < d + 1) {
                if (road[start] + 1 < road[dest]) {
                    road[dest] = road[start] + 1;
                    que.offer(new int[]{dest, road[dest]});
                }
            }
        }
        System.out.println(road[d]);
    }
}

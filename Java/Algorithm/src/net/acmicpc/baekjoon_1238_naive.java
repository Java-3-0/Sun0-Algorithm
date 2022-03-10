//77476kb,748ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1238_naive {
    public static ArrayList<Integer[]>[] link;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        link = new ArrayList[m + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int now = Integer.parseInt(st.nextToken());
            if (link[now] == null) {
                link[now] = new ArrayList<>();
            }
            link[now].add(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[][] distance = new int[N + 1][];
        for (int i = 1; i < N + 1; i++) {
            distance[i] = findMinDistance(i);
        }
        int[] findistance = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            findistance[i] = distance[x][i] + distance[i][x];
        }
        int maxdis = -1;
        for (int i = 1; i < N + 1; i++) {
            maxdis = Math.max(findistance[i], maxdis);
        }
        System.out.println(maxdis);

    }

    private static int[] findMinDistance(int dest) {
        int[] myTowntoX = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            myTowntoX[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        que.offer(new Integer[]{dest, 0});
        myTowntoX[dest] = 0;

        while (!que.isEmpty()) {
            Integer[] now = que.poll();
            int town = now[0];
            int distance = now[1];
            for (int i = 0; i < link[town].size(); i++) {
                int linkedTown = link[town].get(i)[0];
                int linkedTownDistance = link[town].get(i)[1];
                if (distance + linkedTownDistance < myTowntoX[linkedTown]) {
                    myTowntoX[linkedTown] = distance + linkedTownDistance;
                    que.offer(new Integer[]{linkedTown, myTowntoX[linkedTown]});
                }
            }

        }
        return myTowntoX;
    }
}

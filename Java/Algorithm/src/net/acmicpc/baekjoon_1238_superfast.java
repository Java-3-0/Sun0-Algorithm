//22152kb,364ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1238_superfast {
    private static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Integer[]>[] linkToX = new ArrayList[m + 1];
        ArrayList<Integer[]>[] linkToTown = new ArrayList[m + 1];
        for (int i = 0; i < m + 1; i++) {
            linkToX[i] = new ArrayList<>();
            linkToTown[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (start == X)
                linkToX[start].add(new Integer[]{end, weight});
            else if (end == X) {
                linkToTown[end].add(new Integer[]{start, weight});
            } else {
                linkToX[start].add(new Integer[]{end, weight});
                linkToTown[end].add(new Integer[]{start, weight});
            }
        }
        int[] arr1 = findMinDistance(linkToX);
        int[] arr2 = findMinDistance(linkToTown);
        int maxnum = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            maxnum = Math.max(maxnum, arr1[i] + arr2[i]);
        }
        System.out.println(maxnum);
    }

    private static int[] findMinDistance(ArrayList<Integer[]>[] link) {
        int[] myTowntoX = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            myTowntoX[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        que.offer(new Integer[]{X, 0});
        myTowntoX[X] = 0;

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

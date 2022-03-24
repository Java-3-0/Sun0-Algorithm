//17292kb,	264ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11657 {
    public static final int INF = Integer.MAX_VALUE;
    private static long[] distance;
    private static int m;
    private static int n;
    private static int[][] bus;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 최단거리 테이블
        distance = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = INF;
        }

        // 버스 노선 정보 입력받기
        bus = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            bus[i][0] = Integer.parseInt(st.nextToken());
            bus[i][1] = Integer.parseInt(st.nextToken());
            bus[i][2] = Integer.parseInt(st.nextToken());
        }

        // 1번 도시에서 출발
        if (Bellmanford(1))
            System.out.println("-1");
        else {
            for (int i = 2; i < n + 1; i++) {
                System.out.println(distance[i] == INF ? "-1" : distance[i]);
            }
        }
    }

    private static boolean Bellmanford(int start) {
        // 시작하는 도시 0으로 초기화
        distance[start] = 0;

        // n번 도는 이유 : 한 번 더 돌아서 사이클 유무 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int from = bus[j][0];
                int to = bus[j][1];
                int cost = bus[j][2];
                if (distance[from] == INF) continue;
                if (distance[to] > distance[from] + cost) {
                    distance[to] = distance[from] + cost;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

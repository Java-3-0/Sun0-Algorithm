//40476kb,324ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1774 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        double[][] linkWeight = new double[n + 1][n + 1];
        int[][] position = new int[n + 1][2];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                double weight = Math.sqrt(Math.pow(position[i][0] - position[j][0], 2) + Math.pow(position[i][1] - position[j][1], 2));
                linkWeight[i][j] = weight;
                linkWeight[j][i] = weight;

            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            linkWeight[start][end] = 0;
            linkWeight[end][start] = 0;
        }

        double cnt = 0;
        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(1, 0));

        int countVertex = 0;
        while (!que.isEmpty()) {
            Edge temp = que.poll();
            int nowIndex = temp.vertexNum;
            if (visited[nowIndex]) continue;
            cnt += temp.weightToVertex;
            countVertex++;
            if (countVertex == n) break;
            visited[nowIndex] = true;
            for (int nextIndex = 1; nextIndex < n + 1; nextIndex++) {
                if (!visited[nextIndex]) {
                    que.offer(new Edge(nextIndex, linkWeight[nextIndex][nowIndex]));
                }
            }
        }
        System.out.printf("%.2f", cnt);
    }

    static class Edge implements Comparable<Edge> {
        int vertexNum;
        double weightToVertex;

        public Edge(int vertexNum, double weightToVertex) {
            this.vertexNum = vertexNum;
            this.weightToVertex = weightToVertex;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weightToVertex < o.weightToVertex) return -1;
            else if (this.weightToVertex > o.weightToVertex) return 1;
            else return 0;
        }
    }


}
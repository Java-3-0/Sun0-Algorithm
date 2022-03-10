//12476kb,92ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_4386 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        double[][] position = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            position[i][0] = Double.parseDouble(st.nextToken());
            position[i][1] = Double.parseDouble(st.nextToken());
        }

        double[][] linkWeight = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double weight = Math.sqrt(Math.pow(position[i][0] - position[j][0], 2) + Math.pow(position[i][1] - position[j][1], 2));
                linkWeight[i][j] = weight;
                linkWeight[j][i] = weight;
            }
        }

        boolean[] visited = new boolean[n];

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
            for (int nextIndex = 0; nextIndex < n; nextIndex++) {
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

/***
 * 13052mb
 * 116ks
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_17471 {

    private static int n;
    private static boolean[][] edge;
    private static int visited;
    private static int leftSum;
    private static int rightSum;
    private static int[] people;
    private static HashSet<Integer> left;
    private static HashSet<Integer> right;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        people = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.MAX_VALUE;
        edge = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                edge[i][to] = true;
                edge[to][i] = true;
            }
        }

        for (int i = 1; i < (1 << n) - 1; i++) {

            visited = 0;

            left = new HashSet<>();
            right = new HashSet<>();

            leftSum = 0;
            rightSum = 0;

            int leftKid = -1;
            int rightKid = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    left.add(j);
                    leftKid = j;
                } else {
                    right.add(j);
                    rightKid = j;
                }
            }

            leftSum += people[leftKid];
            visited = visited | (1 << leftKid);
            findLeft(leftKid);

            rightSum += people[rightKid];
            visited = visited | (1 << rightKid);
            findRight(rightKid);

            if (Integer.bitCount(visited) != n) continue; // 연결 다 안됨

            cnt = Math.min(cnt, Math.abs(leftSum - rightSum));

        }
        System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);

    }

    private static void findLeft(int i) {
        for (int j = 0; j < n; j++) {
            if (edge[i][j] && left.contains(j) && (visited & (1 << j)) == 0) {
                visited = visited | (1 << j);
                leftSum += people[j];
                findLeft(j);
            }
        }
    }

    private static void findRight(int i) {
        for (int j = 0; j < n; j++) {
            if (edge[i][j] && right.contains(j) && (visited & (1 << j)) == 0) {
                visited = visited | (1 << j);
                rightSum += people[j];
                findRight(j);
            }
        }
    }
}

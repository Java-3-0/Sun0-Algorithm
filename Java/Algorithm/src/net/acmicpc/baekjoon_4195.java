//69368kb,528ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_4195 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 0; t < test_case; t++) {

            int num = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> index = new HashMap<>();
            int cnt = 0;
            parents = new int[200001];
            for (int i = 0, a = 0, b = 0; i < num; i++) {
                st = new StringTokenizer(bf.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();
                if (!index.containsKey(person1)) {
                    a = cnt;
                    index.put(person1, cnt++);
                    parents[a] = -1;
                } else {
                    a = index.get(person1);
                }
                if (!index.containsKey(person2)) {
                    b = cnt;
                    index.put(person2, cnt++);
                    parents[b] = -1;
                } else {
                    b = index.get(person2);
                }
                union(a, b);
                sb.append(-parents[findset(a)] + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int aRoot = findset(a);
        int bRoot = findset(b);
        if (aRoot == bRoot) return;
        if (parents[aRoot] < parents[bRoot]) {
            parents[aRoot] += parents[bRoot];
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] += parents[aRoot];
            parents[aRoot] = bRoot;
        }
        return;
    }

    private static int findset(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findset(parents[a]);
    }
}

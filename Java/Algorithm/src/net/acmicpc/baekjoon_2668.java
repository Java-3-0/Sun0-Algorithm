/***
 * 11688kb
 * 84ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2668 {

    private static int max;
    private static int[] arr;
    private static boolean[] visited;
    private static HashSet<Integer> mother, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine()) - 1;
        }
        max = 0;
        visited = new boolean[n];
        answer = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            mother = new HashSet<>();
            dfs(i, i, 0);
        }
        List<Integer> list = new ArrayList<>(answer);
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int i, int me, int depth) {
        if (i == me && depth != 0) {// 시작점으로 돌아옴
            HashSet<Integer> temp = new HashSet<>(answer);
            temp.removeAll(mother); // 원래꺼에서 지금꺼 삭제
            if (temp.size() == answer.size()) { // 겹치는 게 없으니까 사이즈 유지되는거임
                max += depth;
                answer.addAll(mother);
            } else if (depth > max) {
                max = depth;
                answer = new HashSet<>(mother);
            }
            return;
        }
        if (!visited[me]) { // 자식들 순회
            visited[me] = true;
            mother.add(me);
            dfs(i, arr[me], depth + 1);
        } else {
            return;
        }
    }
}

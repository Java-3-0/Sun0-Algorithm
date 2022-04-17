/***
 * 12388kb
 * 100ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, int[]> choochun = new HashMap<>();

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            int student = Integer.parseInt(st.nextToken());

            if (choochun.containsKey(student)) { // 이미 있는 애라면
                choochun.put(student, new int[]{choochun.get(student)[0] + 1, choochun.get(student)[1]});
            } else if (choochun.size() < n) { // 없는 애인데 자리가 남았다면
                choochun.put(student, new int[]{1, i});
            } else { // 없는데 자리도 없다면
                int order = Integer.MAX_VALUE;
                int index = 0;
                int choochunCnt = Integer.MAX_VALUE;
                for (Integer key : choochun.keySet()) {
                    int[] now = choochun.get(key);
                    if (choochunCnt > now[0]) {
                        index = key;
                        choochunCnt = now[0];
                        order = now[1];
                    } else if (choochunCnt == now[0]) {
                        if (order > now[1]) {
                            index = key;
                            order = now[1];
                        }
                    }
                }
                choochun.remove(index);
                choochun.put(student, new int[]{1, i});
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : choochun.keySet()) {
            list.add(key);
        }
        Collections.sort(list);

        for (Integer num : list) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}

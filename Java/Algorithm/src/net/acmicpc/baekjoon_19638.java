/***
 * 27448kb
 * 356ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int cnt = 0;

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            que.offer(Integer.parseInt(bf.readLine()));
        }

        for (int i = 0; i < t; i++) {
            int now = que.peek();
            if (now == 1) continue;
            if (now < h) break;
            que.offer(que.poll() / 2);
            cnt++;
        }

        if (que.peek() < h)
            sb.append("YES\n").append(cnt);
        else
            sb.append("NO\n").append(que.poll());

        System.out.println(sb);
    }
}

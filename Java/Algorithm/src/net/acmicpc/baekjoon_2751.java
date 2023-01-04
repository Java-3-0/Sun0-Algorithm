/***
 * 207572kb
 * 1712ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            que.offer(Integer.parseInt(bf.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);
    }
}

/***
 * 	24628kb
 * 	360ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            que.offer(Integer.parseInt(bf.readLine()));
        }

        int cnt = 0;
        while (que.size() > 1) {
            int num = que.poll() + que.poll();
            cnt += num;
            que.offer(num);
        }
        System.out.println(cnt);
    }
}

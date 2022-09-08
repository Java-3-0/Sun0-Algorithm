/***
 * 11508kb
 * 80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11058 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i < 101; i++) {
            dp[i] = Math.max(dp[i - 1] + 1, dp[i - 4] * 3);
            dp[i] = Math.max(dp[i], dp[i - 3] * 2);
            dp[i] = Math.max(dp[i], dp[i - 5] * 4);
        }
        System.out.println(dp[n]);
//        Queue<int[]> que = new ArrayDeque<>();
//        que.offer(new int[]{0, 0, 0, 0});
//        while (!que.isEmpty()) {
//            int[] now = que.poll();
//            int total = now[0];
//            int choose = now[1];
//            int clipboard = now[2];
//            int depth = now[3];
//
//            if (depth == n) {
//                max = Math.max(total, max);
//            } else {
//                que.offer(new int[]{total + 1, choose, clipboard, depth + 1});
//                que.offer(new int[]{total, total, clipboard, depth + 1});
//                que.offer(new int[]{total, choose, choose, depth + 1});
//                que.offer(new int[]{total + clipboard, choose, clipboard, depth + 1});
//            }
//        }
//        System.out.println(max);

    }
}

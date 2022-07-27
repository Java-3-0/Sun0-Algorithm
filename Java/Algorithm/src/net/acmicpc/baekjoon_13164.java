/***
 * 59248kb
 * 412ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

//        PriorityQueue<Integer> que = new PriorityQueue<>();
        int[] arr = new int[n - 1];
        int index = 0;
        st = new StringTokenizer(bf.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[index++] = (now - prev);
            prev = now;
        }

        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - k; i++) {
            answer += arr[i];
        }
//        while (que.size() >= k) {
//            answer += que.poll();
//        }
        System.out.println(answer);
    }
}

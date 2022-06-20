/***
 * 	130256kb
 * 	1628ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(bag);

        long cnt = 0;
        int j = 0;
        PriorityQueue<Integer> canBag = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {

            while (j < n && jewel[j][0] <= bag[i]) {
                canBag.offer(jewel[j][1]);
                j++;
            }
            if (!canBag.isEmpty())
                cnt += canBag.poll();

        }
        System.out.println(cnt);
    }
}

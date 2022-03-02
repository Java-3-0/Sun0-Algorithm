//27124kb,324ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int[] acnt = new int[4];
            int[] bcnt = new int[4];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int alen = Integer.parseInt(st.nextToken());
            for (int j = 0; j < alen; j++) {
                int now = Integer.parseInt(st.nextToken());
                acnt[now - 1]++;
            }
            st = new StringTokenizer(bf.readLine());
            int blen = Integer.parseInt(st.nextToken());
            for (int j = 0; j < blen; j++) {
                int now = Integer.parseInt(st.nextToken());
                bcnt[now - 1]++;
            }
            System.out.println(WhoIsWinner(acnt, bcnt));
        }
    }

    private static char WhoIsWinner(int[] acnt, int[] bcnt) {
        for (int i = 3; i >= 0; i--) {
            if (acnt[i] > bcnt[i])
                return 'A';
            else if (acnt[i] < bcnt[i])
                return 'B';
        }
        return 'D';
    }

}

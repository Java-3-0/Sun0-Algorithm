/***
 * 	33692kb
 * 	372ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_16471 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] zooan = new int[n];
        int[] sajang = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            zooan[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(zooan);

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            sajang[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sajang);

        int index = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (zooan[index] < sajang[i]) {
                count++;
                index++;
            }
        }
        if (count >= ((n + 1) / 2))
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}

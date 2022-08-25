/***
 * 11476kb
 * 76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2502 {

    private static int[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        fibo = new int[d + 1];
        Arrays.fill(fibo, -1);
        // 1 2  3   4    5     6      7
        // a b a+b a+2b 2a+3b 3a+5b 5a+8b


        int a = fib(d - 1);
        int b = fib(d);
        int i = 1;
        for (i = 1; a * i <= k; i++) {
            if ((k - a * i) % b == 0) break;
        }
        int j = (k - a * i) / b;
        System.out.println(i);
        System.out.println(j);
    }

    private static int fib(int i) {
        if (fibo[i] != -1) return fibo[i];
        if (i == 1)
            return fibo[i] = 0;
        if (i == 2)
            return fibo[i] = 1;
        return fibo[i] = fib(i - 1) + fib(i - 2);
    }
}

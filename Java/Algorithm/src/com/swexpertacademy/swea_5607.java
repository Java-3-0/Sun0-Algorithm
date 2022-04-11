/***
 * 27,540 kb
 * 125 ms
 */
package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5607 {

    private static final long MOD = 1234567891;
    private static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        factorial = new long[1000001];
        Arrays.fill(factorial, -1);
        factorial[1] = 1;
        int test_case = Integer.parseInt(bf.readLine());


        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long cnt = Combination(n, r);
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static long Combination(int n, int r) {

        // n!%p
        long num1 = getFactorial(n) % MOD;

        // (n-r)!^(p-2) %p
        long num2 = getPow(getFactorial(n - r), MOD - 2) % MOD;

        // r!^(p-2) %p
        long num3 = getPow(getFactorial(r), MOD - 2) % MOD;

        return ((num1 * num2) % MOD * num3) % MOD;
    }

    private static long getFactorial(int n) {
        if (factorial[n] != -1) return factorial[n];
        for (int i = 2; i < n + 1; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }
        return factorial[n];
    }

    private static long getPow(long down, long upper) {
        if (upper == 1) return down;

        long pow = getPow(down, upper / 2) % MOD;
        if (upper % 2 == 0)
            return (pow * pow) % MOD;
        else
            return ((pow * pow) % MOD * down) % MOD;
    }
}

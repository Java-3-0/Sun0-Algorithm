/***
 * 32560kb
 * 212ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        boolean[] primeNum = new boolean[n + 1];
        Arrays.fill(primeNum, true);
        primeNum[0] = false;
        primeNum[1] = false;
        //에라토스테네스
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            for (int j = i * i; j < n + 1; j += i) {
                primeNum[j] = false;
            }
        }

        // 내 소수들 넣어두기
        int[] myPrime = new int[n + 1];
        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            if (primeNum[i])
                myPrime[index++] = i;
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while (start <= end) {
            if (sum < n) {
                if (end < index) {
                    sum += myPrime[end];
                    end++; // index값까지 감
                } else if (end == index)
                    break;
            } else if (sum > n) {
                if (start + 1 < index) {
                    sum -= myPrime[start];
                    start++;
                }
            } else {
                cnt++;
                sum -= myPrime[start];
                start++;
                if (end == index)
                    break;
            }
        }
        System.out.println(cnt);
    }
}

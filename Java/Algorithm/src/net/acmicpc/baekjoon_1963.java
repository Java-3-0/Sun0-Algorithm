/***
 * 12184kb
 * 88ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1963 {

    private static boolean[] primeNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        primeNumber = new boolean[10000];
        getPrimeNumber();

        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(transform(from, to)).append("\n");
        }
        System.out.println(sb);
    }

    private static void getPrimeNumber() {
        primeNumber[0] = primeNumber[1] = true;

        for (int i = 2; i * i < 10000; i++) {
            if (!primeNumber[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    primeNumber[j] = true;
                }
            }
        }
    }

    private static String transform(int from, int to) {

        boolean[] visited = new boolean[10001];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{from, 0});
        visited[from] = true;

        while (!que.isEmpty()) {
            //System.out.println(que);
            int[] polled = que.poll();
            int now = polled[0];
            int cnt = polled[1];
            if (now == to)
                return String.valueOf(cnt);
            int thousand = now / 1000;
            now %= 1000;
            int hundred = now / 100;
            now %= 100;
            int ten = now / 10;
            int one = now % 10;

            for (int i = 1; i < 10; i++) {
                if (thousand == i) continue;
                else {
                    int newNum = newNumber(i, hundred, ten, one);
                    if (!visited[newNum] && !primeNumber[newNum]) {
                        que.offer(new int[]{newNum, cnt + 1});
                        visited[newNum] = true;
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                if (hundred == i) continue;
                else {
                    int newNum = newNumber(thousand, i, ten, one);
                    if (!visited[newNum] && !primeNumber[newNum]) {
                        que.offer(new int[]{newNum, cnt + 1});
                        visited[newNum] = true;
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                if (ten == i) continue;
                else {
                    int newNum = newNumber(thousand, hundred, i, one);
                    if (!visited[newNum] && !primeNumber[newNum]) {
                        que.offer(new int[]{newNum, cnt + 1});
                        visited[newNum] = true;
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                if (one == i) continue;
                else {
                    int newNum = newNumber(thousand, hundred, ten, i);
                    if (!visited[newNum] && !primeNumber[newNum]) {
                        que.offer(new int[]{newNum, cnt + 1});
                        visited[newNum] = true;
                    }
                }
            }
        }
        return "Impossible";
    }

    private static int newNumber(int i, int hundred, int ten, int one) {
        return i * 1000 + hundred * 100 + ten * 10 + one;
    }
}

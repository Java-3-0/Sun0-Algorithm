/***
 * 	22416kb
 * 	208ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class baekjoon_26075 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] s = bf.readLine().toCharArray();
        char[] t = bf.readLine().toCharArray();

        Stack<Integer> indexS = new Stack<>();
        Stack<Integer> indexT = new Stack<>();
        for (int i = 0; i < n + m; i++) {
            if (s[i] == '1')
                indexS.add(i);
            if (t[i] == '1')
                indexT.add(i);
        }

        long x = 0;
        long y = 0;
        while (!indexS.isEmpty() || !indexT.isEmpty()) {
            int popS = indexS.pop();
            int popT = indexT.pop();

            int sum = popS + popT;
            int mid = sum / 2;
            int distanceToS = Math.abs(mid - popS);
            int distanceToT = Math.abs(mid - popT);
            if (x > y) {
                y += Math.max(distanceToS, distanceToT);
                x += Math.min(distanceToS, distanceToT);
            } else {
                x += Math.max(distanceToS, distanceToT);
                y += Math.min(distanceToS, distanceToT);
            }
        }
        long answer = x * x + y * y;
        System.out.println(answer);
    }


}

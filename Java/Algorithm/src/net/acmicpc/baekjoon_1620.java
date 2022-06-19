/***
 * 61944kb
 * 496ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> findByNum = new HashMap<>();
        HashMap<String, Integer> findByString = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String poketmon = bf.readLine();
            findByNum.put(i, poketmon);
            findByString.put(poketmon, i);
        }

        for (int i = 0; i < m; i++) {
            String input = bf.readLine();
            if (isNum(input))
                sb.append(findByNum.get(Integer.parseInt(input))).append("\n");
            else
                sb.append(findByString.get(input)).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isNum(String input) {
        return input.charAt(0) >= '0' && input.charAt(0) <= '9';
    }
}

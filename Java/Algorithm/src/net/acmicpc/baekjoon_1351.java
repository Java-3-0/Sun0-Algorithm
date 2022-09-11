/***
 * 11788kb
 * 80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_1351 {

    private static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Long n = Long.parseLong(st.nextToken());
        Long p = Long.parseLong(st.nextToken());
        Long q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);
        System.out.println(topdown(n, p, q));
    }

    private static long topdown(long n, long p, long q) {

        if (map.containsKey(n)) // 있으면 반환
            return map.get(n);

        if (!map.containsKey(n / p)) { //없으면 반 쪼개기
            map.put(n / p, topdown(n / p, p, q));
        }
        if (!map.containsKey(n / q)) {
            map.put(n / q, topdown(n / q, p, q));
        }

        return map.get(n / p) + map.get(n / q);
    }
}

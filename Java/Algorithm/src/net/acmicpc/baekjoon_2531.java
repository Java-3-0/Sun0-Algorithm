/***
 * 19800kb
 * 216ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_2531 {

    private static HashMap<Integer, Integer> eatSushi;
    private static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        eatSushi = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int cnt = Integer.MIN_VALUE;
        boolean isCouponUsed = false;
        sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(bf.readLine());
        }

        int l = 0;
        int r = 0;

        // k개 우선 넣기
        while (k > 0) {
            PutSushi(r);
            k--;
            r = (r + 1) % n;
        }
        cnt = eatSushi.size();
        isCouponUsed = eatSushi.containsKey(c);

        for (int i = 0; i < n + 1; i++) {
            // l값 제외
            RemoveSushi(l);
            l = (l + 1) % n;

            PutSushi(r);
            r = (r + 1) % n;

            if (cnt < eatSushi.size()) {
                cnt = eatSushi.size();
                isCouponUsed = eatSushi.containsKey(c);
            } else if (cnt == eatSushi.size() && !eatSushi.containsKey(c)) {
                isCouponUsed = eatSushi.containsKey(c);
            }
        }

        if (isCouponUsed)
            System.out.println(cnt);
        else
            System.out.println(cnt + 1);
    }

    private static void RemoveSushi(int l) {
        if (eatSushi.containsKey(sushi[l])) {
            int sushiCnt = eatSushi.get(sushi[l]);
            if (sushiCnt > 1)
                eatSushi.put(sushi[l], sushiCnt - 1);
            else
                eatSushi.remove(sushi[l]);
        }
    }

    private static void PutSushi(int r) {
        if (eatSushi.containsKey(sushi[r])) { //초밥 있으면 +1
            eatSushi.put(sushi[r], eatSushi.get(sushi[r]) + 1);
        } else { // 없으면 1로 넣기
            eatSushi.put(sushi[r], 1);
        }
    }
}

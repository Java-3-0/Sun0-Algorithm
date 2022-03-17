//209320kb,1068ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        int total = 0;
        Stack<HW> hw = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if (!hw.empty()) {
                    HW now = hw.pop();
                    now.time -= 1;
                    if (now.time == 0) total += now.score;
                    else hw.push(now);
                }
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;
                if (time == 0)
                    total += score;
                else
                    hw.push(new HW(score, time));

            }
        }
        System.out.println(total);
    }

    static class HW {
        int score;
        int time;

        public HW(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}

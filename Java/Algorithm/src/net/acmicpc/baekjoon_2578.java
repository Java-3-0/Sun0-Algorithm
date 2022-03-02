//11572kb,80ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_2578 {
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new boolean[5][5];
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new Integer[]{i, j});
            }
        }
        int cnt = 0;
        loop:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                cnt++;
                Integer[] temp = map.get(num);
                arr[temp[0]][temp[1]] = true;
                if (isBingo())
                    break loop;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isBingo() {

        int bingo = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[0][i]) {
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (arr[j][i])
                        cnt++;
                }
                if (cnt == 5) bingo++;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (arr[i][0]) {
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j]) {
                        cnt++;
                    }
                }
                if (cnt == 5) bingo++;
            }
        }
        if (arr[0][0]) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][j]) {
                    cnt++;
                }
            }
            if (cnt == 5) bingo++;
        }
        if (arr[4][0]) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[4 - j][j]) {
                    cnt++;
                }
            }
            if (cnt == 5) bingo++;
        }
        return bingo >= 3;

    }
}

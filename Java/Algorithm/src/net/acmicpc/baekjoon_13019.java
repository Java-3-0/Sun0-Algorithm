/***
 * 11472kb
 * 80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] jjin_cnt;
        int[] jjap_cnt;

        String jjin = bf.readLine();
        String jjap = bf.readLine();
        jjin_cnt = count(jjin);
        jjap_cnt = count(jjap);

        if (!isAlphabetCountSame(jjin_cnt, jjap_cnt)) {
            System.out.println("-1");
        } else {
            System.out.println(jjinTojjap(jjin, jjap));
        }
    }

    private static int jjinTojjap(String jjin, String jjap) {
        int cnt = 0;
        int right = jjin.length() - 1;
        for (int i = right; i >= 0; i--) {
            if (jjin.charAt(i) != jjap.charAt(right)) cnt++;
            else right--;
        }
        return cnt;
    }

    private static boolean isAlphabetCountSame(int[] jjin_cnt, int[] jjap_cnt) {
        for (int i = 0; i < 26; i++) {
            if (jjin_cnt[i] != jjap_cnt[i]) return false;
        }
        return true;
    }

    private static int[] count(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        return arr;
    }
}

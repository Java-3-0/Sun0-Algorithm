//12152kb,76ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int maxcnt = 0;
        ArrayList<Integer> arr = null;
        for (int i = 0; i < n; i++) {
            int first = n;
            int second = n - i;
            int cnt = 1;
            while (second >= 0) {
                cnt++;
                int temp = second;
                second = first - second;
                first = temp;
            }
            if (maxcnt < cnt) {
                ArrayList<Integer> temparr = new ArrayList<>();
                maxcnt = cnt;
                temparr.add(n);
                first = n;
                second = n - i;
                while (second >= 0) {
                    temparr.add(second);
                    int temp = second;
                    second = first - second;
                    first = temp;
                }
                arr = temparr;
            }
        }
        System.out.println(maxcnt);
        for (Integer a : arr
        ) {
            System.out.print(a + " ");
        }
    }
}

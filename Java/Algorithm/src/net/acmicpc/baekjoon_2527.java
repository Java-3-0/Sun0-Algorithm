//11576kb,80ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());


            if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
                System.out.println("d");
            } else if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3)
                    || (x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4)) {
                System.out.println("c");
            } else if (x2 == x3 || x1 == x4 || y2 == y3 || y1 == y4)
                System.out.println("b");
            else
                System.out.println("a");
        }
    }
}

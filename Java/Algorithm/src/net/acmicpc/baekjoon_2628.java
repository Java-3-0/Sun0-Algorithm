//11604kb,80ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        row.add(n);
        row.add(0);
        col.add(m);
        col.add(0);
        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(bf.readLine());
            int kind = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            switch (kind) {
                case 0:
                    col.add(number);
                    break;
                case 1:
                    row.add(number);
                    break;
            }
        }
        Collections.sort(row);
        Collections.sort(col);

        int rownum = row.get(0);
        int prev = row.get(0);
        for (int i = 1; i < row.size(); i++) {
            if (rownum < row.get(i) - prev) {
                rownum = row.get(i) - prev;
            }
            prev = row.get(i);
        }

        int colnum = col.get(0);
        prev = col.get(0);
        for (int i = 1; i < col.size(); i++) {
            if (colnum < col.get(i) - prev) {
                colnum = col.get(i) - prev;
            }
            prev = col.get(i);
        }
        System.out.println(colnum * rownum);
    }
}

/***
 * 	12120kb
 * 	76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_23306 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        System.out.println("? 1");
        System.out.flush();

        int first = Integer.parseInt(bf.readLine());

        System.out.println("? " + n);
        System.out.flush();

        int end = Integer.parseInt(bf.readLine());

        if (first > end)
            System.out.println("! -1");
        else if (first < end)
            System.out.println("! 1");
        else
            System.out.println("! 0");
    }
}

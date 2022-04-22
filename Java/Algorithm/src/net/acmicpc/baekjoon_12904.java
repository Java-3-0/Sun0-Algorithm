/***
 * 11880kb
 * 92ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_12904 {

    private static String origin;
    private static StringBuilder sb;
    private static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        origin = bf.readLine();
        sb = new StringBuilder(bf.readLine());

        while (origin.length() < sb.length()) {
            if (sb.charAt(sb.length() - 1) == 'A')
                sb.setLength(sb.length() - 1);
            else {
                sb.setLength(sb.length() - 1);
                sb.reverse();
            }
        }
        if (sb.toString().equals(origin))
            System.out.println("1");
        else
            System.out.println("0");
    }

}

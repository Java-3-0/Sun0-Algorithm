/***
 * 11500kb
 * 76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());

        if (n % 7 == 0 || (n - 2) % 7 == 0)
            System.out.println("CY");
        else
            System.out.println("SK");
    }
}

/***
 * 11512kb
 * 76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9661 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());

        if (n % 5 == 0 || (n - 2) % 5 == 0)
            System.out.println("CY");
        else
            System.out.println("SK");
    }
}

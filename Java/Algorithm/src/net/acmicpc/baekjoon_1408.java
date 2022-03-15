package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(bf.readLine(), ":");
        StringTokenizer st2 = new StringTokenizer(bf.readLine(), ":");
        int h1 = Integer.parseInt(st1.nextToken());
        int m1 = Integer.parseInt(st1.nextToken());
        int s1 = Integer.parseInt(st1.nextToken());
        int h2 = Integer.parseInt(st2.nextToken());
        int m2 = Integer.parseInt(st2.nextToken());
        int s2 = Integer.parseInt(st2.nextToken());


        int h3, m3, s3;
        if (s2 < s1) {
            s3 = s2 + 60 - s1;
            m2 -= 1;
        } else {
            s3 = s2 - s1;
        }

        if (m2 < m1) {
            m3 = m2 + 60 - m1;
            h2 -= 1;
        } else {
            m3 = m2 - m1;
        }
        if (h2 < h1) {
            h3 = h2 + 24 - h1;
        } else {
            h3 = h2 - h1;
        }
        System.out.printf("%02d:%02d:%02d", h3, m3, s3);
    }
}

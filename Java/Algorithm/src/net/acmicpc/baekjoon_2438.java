package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2438 {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        Bam_Haneul_e_Pearl(n);
        System.out.println(sb);
    }

    private static void Bam_Haneul_e_Pearl(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }
}

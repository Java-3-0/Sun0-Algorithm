package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_1759 {

    private static int L;
    private static int C;
    private static StringBuilder passwordSet, password;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        passwordSet = new StringBuilder();
        password = new StringBuilder();


        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char[] alphabet = bf.readLine().replace(" ", "").toCharArray();
        Arrays.sort(alphabet);

        for (int i = (int) Math.pow(2, C); i >= 0; i--) {
            if (Integer.bitCount(i) == L) {
                String str = Integer.toBinaryString(i);
                password.setLength(0);
                int vowelCnt = 0;
                int nonVowelCnt = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '1') {
                        if (vowels.contains(alphabet[j + (C - str.length())]))
                            vowelCnt++;
                        else
                            nonVowelCnt++;
                        password.append(alphabet[j + (C - str.length())]);
                    }
                }

                if (vowelCnt >= 1 && nonVowelCnt >= 2) {
                    passwordSet.append(password).append("\n");
                }
            }
        }
        System.out.println(passwordSet);

    }


}

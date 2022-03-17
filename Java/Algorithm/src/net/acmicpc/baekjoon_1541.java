//11700kb,84ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1541 {
    private static int num_index;
    private static int oper_index;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split("(?=[-+])|(?<=[-+])");
        int[] plus = new int[str.length];

        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(("-"))) continue;
            else if (str[i].equals("+")) {
                plus[index - 1] = plus[index - 1] + Integer.parseInt(str[i + 1]);
                i += 1;
            } else {
                plus[index++] = Integer.parseInt(str[i]);
            }
        }
        int num = plus[0];
        for (int i = 1; i < index; i++) {
            num -= plus[i];
        }
        System.out.println(num);
    }
}

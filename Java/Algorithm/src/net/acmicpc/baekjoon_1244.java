//11612kb,76ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(bf.readLine());
        int[] arr = new int[num + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            switch (gender) {
                case 1:
                    for (int j = number; j < num + 1; j += number) {
                        arr[j] = 1 - arr[j];
                    }
                    break;
                case 2:
                    arr[number] = 1 - arr[number];
                    for (int j = number + 1, k = number - 1; j < num + 1 && k > 0; j++, k--) {
                        if (arr[j] == arr[k]) {
                            arr[j] = 1 - arr[j];
                            arr[k] = 1 - arr[k];
                        } else
                            break;
                    }
                    break;
            }
        }
        for (int i = 1; i <= num; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0 && i > 0)
                System.out.println();
        }
    }
}

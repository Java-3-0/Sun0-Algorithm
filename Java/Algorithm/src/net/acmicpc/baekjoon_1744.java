/***
 * 	11564kb
 * 	80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Integer[] numbers = new Integer[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(numbers, Collections.reverseOrder());


        int sum = 0;
        int i = 0;
        for (i = 0; i < N; i++) {
            if (numbers[i] <= 0)
                break;
            if (i + 1 < N && numbers[i] * numbers[i + 1] > numbers[i] + numbers[i + 1]) {
                sum += numbers[i] * numbers[i + 1];
                i++;
            } else {
                sum += numbers[i];
            }
        }

        for (int j = N - 1; j >= i; j--) {
            if (j - 1 >= 0 && numbers[j] * numbers[j - 1] > numbers[j] + numbers[j - 1]) {
                sum += numbers[j] * numbers[j - 1];
                j--;
            } else {
                sum += numbers[j];
            }
        }
        System.out.println(sum);
    }
}

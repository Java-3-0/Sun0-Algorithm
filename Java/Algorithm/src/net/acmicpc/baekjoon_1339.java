/***
 * 11576kb
 * 80ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];

        ArrayList<alpahbet> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new alpahbet());
        }

        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine();
            for (int j = 0; j < arr[i].length(); j++) {
                int index = arr[i].charAt(j) - 'A';
                list.get(index).count(arr[i].length() - j - 1);
            }
        }
        Collections.sort(list);
        long sum = 0;
        int num = 9;
        for (int i = 0; i < 26; i++) {
            sum += list.get(i).sum(num--);
        }
        System.out.println(sum);
    }

    static class alpahbet implements Comparable<alpahbet> {
        int[] orderCount; //

        public alpahbet() {
            this.orderCount = new int[8];
        }

        public void count(int i) {
            orderCount[i]++;
        }

        @Override
        public int compareTo(alpahbet o2) {
            long o1Sum = 0;
            long o2Sum = 0;
            int num = 1;
            for (int i = 0; i < 8; i++) {
                o1Sum += num * this.orderCount[i];
                o2Sum += num * o2.orderCount[i];
                num *= 10;
            }
            if (o1Sum > o2Sum)
                return -1;
            else return 1;
        }

        public long sum(int num) {
            long maxsum = 0;
            for (int i = 0; i < 8; i++) {
                maxsum += num * this.orderCount[i];
                num *= 10;
            }
            return maxsum;
        }
    }
}

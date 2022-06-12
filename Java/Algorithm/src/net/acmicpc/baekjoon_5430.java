/***
 * 76596kb
 * 476ms
 */

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class baekjoon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test_case = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= test_case; t++) {
            char[] command = bf.readLine().toCharArray();
            int n = Integer.parseInt(bf.readLine());
            sunyoung me = new sunyoung(bf.readLine().toCharArray());

            boolean flg = true;
            for (int i = 0; i < command.length; i++) {
                if (!me.execute(command[i])) {
                    sb.append("error\n");
                    flg = false;
                    break;
                }
            }
            if (flg) {
                sb.append(me);
            }
        }
        System.out.println(sb);
    }

    static class sunyoung {
        Deque<Integer> que;
        boolean isReverse;

        sunyoung(char[] arr) {
            this.que = new ArrayDeque<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '[' || arr[i] == ']' || arr[i] == ',') continue;
                int num = 0;
                while (arr[i] >= '0' && arr[i] <= '9') {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                que.offer(num);
            }
            this.isReverse = false;
        }

        public boolean execute(char command) {
            if (command == 'R') {
                this.isReverse = !this.isReverse;
                return true;
            } else {
                if (this.que.size() == 0) {
                    return false;
                } else {
                    if (isReverse)
                        this.que.pollLast();
                    else
                        this.que.poll();
                    return true;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append("[");
            Iterator<Integer> iterator;
            if (isReverse) {
                iterator = que.descendingIterator();
            } else {
                iterator = que.iterator();
            }
            while (iterator.hasNext()) {
                s.append(iterator.next()).append(",");
            }
            if (s.length() > 1)
                s.setLength(s.length() - 1);
            s.append("]");
            return s + "\n";
        }
    }
}

/*** StringBuilder version
 * 11880kb
 * 92ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_12904 {

    //    private static String origin;
//    private static StringBuilder sb;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        sb = new StringBuilder();
//
//        origin = bf.readLine();
//        sb = new StringBuilder(bf.readLine());
//
//        while (origin.length() < sb.length()) {
//            if (sb.charAt(sb.length() - 1) == 'A')
//                sb.setLength(sb.length() - 1);
//            else {
//                sb.setLength(sb.length() - 1);
//                sb.reverse();
//            }
//        }
//        if (sb.toString().equals(origin))
//            System.out.println("1");
//        else
//            System.out.println("0");
//    }

    /*** two-pointer version
     * 11488kb
     * 76ms
     */
    private static String origin;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean isReverse = false;
        origin = bf.readLine();
        char[] ch = bf.readLine().toCharArray();
        int l = 0;
        int r = ch.length - 1;

        while (origin.length() < (r - l + 1)) {
            if (isReverse) {
                if (ch[l] == 'B')
                    isReverse = false;
                l++;
            } else {
                if (ch[r] == 'B')
                    isReverse = true;
                r--;
            }
        }

        if (isReverse) {
            for (int i = r; i >= l; i--) {
                sb.append(ch[i]);
            }
        } else {
            for (int i = l; i <= r; i++) {
                sb.append(ch[i]);
            }
        }

        if (sb.toString().equals(origin))
            System.out.println("1");
        else
            System.out.println("0");
    }
}

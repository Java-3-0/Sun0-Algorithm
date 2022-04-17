/***
 * 11608kb
 * 76ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int powerBar = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        HashSet<Integer> usingSet = new HashSet<>();

        int[] usageOrder = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            usageOrder[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (usingSet.contains(usageOrder[i])) continue;
            if (usingSet.size() < powerBar && !usingSet.contains(usageOrder[i])) { // 자리 남고 안꽂혀있으면 넣기
                usingSet.add(usageOrder[i]);
            } else if (usingSet.size() >= powerBar && !usingSet.contains(usageOrder[i])) { // 자리 안남으면 돌면서 가장 늦은애 뽑기
                int lastOrderIndex = 0;
                int lastOrder = 0;
                for (Integer usage : usingSet) {
                    boolean comeOut = false;
                    for (int j = i + 1; j < n; j++) {
                        if (usageOrder[j] == usage) {
                            if (lastOrderIndex < j) {
                                lastOrderIndex = j;
                                lastOrder = usage;
                            }
                            comeOut = true;
                            break;
                        }
                    }
                    if (!comeOut) {
                        lastOrder = usage;
                        break;
                    }
                }
                cnt++;
                usingSet.remove(lastOrder);
                usingSet.add(usageOrder[i]);
            }

        }
        System.out.println(cnt);
    }
}

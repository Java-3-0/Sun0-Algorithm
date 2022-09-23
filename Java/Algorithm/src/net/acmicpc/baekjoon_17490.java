/***
 * 345168kb
 * 1532ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_17490 {

    private static int[] parents;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        parents = new int[n];
        cost = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> unlinked = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int building1 = Integer.parseInt(st.nextToken()) - 1;
            int building2 = Integer.parseInt(st.nextToken()) - 1;
            if ((building1 == 0 && building2 == n - 1) || (building1 == n - 1 && building2 == 0))
                unlinked.add(n);
            else if (building1 > building2)
                unlinked.add(building1);
            else
                unlinked.add(building2);
        }

        HashMap<Integer, Integer> neededCost = new HashMap<>();
        int minCost = Integer.MAX_VALUE;
        int mother = 0;
        for (int i = 0; i < n; i++) {
            if (unlinked.contains(i)) {
                neededCost.put(mother, minCost);
                mother = i;
                minCost = cost[i];
            } else {
                minCost = Math.min(minCost, cost[i]);
            }
        }

        if (neededCost.size() == 0) {
            //지금까지 쭉 하나로 이어진 상태 -> 0-n번째가 안이어져 있어도 상관이 없음
        } else if (neededCost.size() == 1) { // 한줄로 이어졌는데 0~n 사이가 한 번 끊어진 상태
            // 0-n연결고리가 끊어진 경우
            if (unlinked.contains(n)) {
                neededCost.put(mother, minCost);
            } else { // 0-n연결고리가 붙은 경우 -> 결국 얘도 일렬로 되어 있음
                neededCost.clear();
            }
        } else {
            if (unlinked.contains(n)) {
                neededCost.put(mother, minCost);
            } else { // 0-n연결고리가 붙은 경우
                minCost = Math.min(neededCost.get(0), minCost);
                neededCost.put(0, minCost);
            }
        }


        long neededCostSum = 0;
        for (Integer key : neededCost.keySet()) {
            System.out.println(key + " " + neededCost.get(key));
            neededCostSum += neededCost.get(key);
        }

        if (neededCostSum <= k)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

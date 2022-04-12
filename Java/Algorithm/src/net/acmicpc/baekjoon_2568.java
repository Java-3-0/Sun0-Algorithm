/***
 * 71960kb
 * 720ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2568 {

    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] indexLog = new int[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> (o1[0] - o2[0]));

        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int index = Binarysearch(arr[i][1]);
            distance[index] = arr[i][1];
            indexLog[i] = index;
            if (index > maxIndex)
                maxIndex = index;
        }

        sb.append(n - maxIndex).append("\n");

        ArrayList<Integer> list = new ArrayList<>();
        int nowIndex = maxIndex;
        int i = n - 1;
        while (nowIndex > 0 || i >= 0) {
            if (nowIndex == indexLog[i])
                nowIndex--;
            else
                list.add(arr[i][0]);
            i--;
        }
        Collections.sort(list);
        for (Integer num : list)
            sb.append(num + "\n");
        System.out.println(sb);
    }

    private static int Binarysearch(int num) {
        int l = 1;
        int r = distance.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (distance[mid] > num)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }
}

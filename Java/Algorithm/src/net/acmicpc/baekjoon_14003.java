/***
 * 313360kb
 * 1008ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_14003 {

    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] indexArr = new int[n];
        int[] arr = new int[n];
        int maxIndex = Integer.MIN_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int index = Binarysearch(arr[i]);
            distance[index] = arr[i];
            indexArr[i] = index;
            if (maxIndex < index)
                maxIndex = index;
        }
        int nowIndex = maxIndex;
        int i = n - 1;
        Stack<Integer> stack = new Stack<>();
        while (nowIndex > 0 && i > -1) {
            if (indexArr[i] == nowIndex) {
                stack.push(arr[i]);
                nowIndex--;
            }
            i--;
        }
        while (!stack.empty())
            sb.append(stack.pop() + " ");
        System.out.println(maxIndex);
        System.out.println(sb);
    }

    private static int Binarysearch(int num) {
        int l = 1;
        int r = distance.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (distance[mid] < num) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }
}

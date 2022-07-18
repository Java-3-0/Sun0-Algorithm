/***
 * 	25480kb
 * 	240ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_21758 {

    private static int maxHoney;
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        maxHoney = 0;

        // 맨 왼쪽에 꿀 놓았을 때 ==왼쪽에 꿀, 오른쪽엔 꿀벌쓰
        //perfect
        for (int i = 1; i < n - 1; i++) {
            maxHoney = Math.max(maxHoney, arr[n - 2] - arr[i] + arr[i - 1] + arr[i - 1]);
        }

        //perfect
        for (int i = 1; i < n - 1; i++) {
            //벌 꿀 벌
            maxHoney = Math.max(maxHoney, arr[i] - arr[0] + arr[n - 2] - arr[i - 1]);
        }
        // 벌 벌 꿀
        //100(고정꿀스) 100 50 49 48 47 46 100 100(꿀스)
        // 맨 오른쪽에 꿀 놓았을 때 ==오른쪽에 꿀, 왼쪽엔 꿀벌쓰
        for (int i = 1; i < n - 1; i++) {
            maxHoney = Math.max(maxHoney, (arr[n - 1] - arr[i] + arr[i - 1] - arr[0]) + (arr[n - 1] - arr[i]));
        }

        System.out.println(maxHoney);
    }
}

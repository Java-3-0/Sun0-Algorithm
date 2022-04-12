/***
 * 28088kb
 * 280ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        int[] router = new int[n];

        for (int i = 0; i < n; i++) {
            router[i] = Integer.parseInt(bf.readLine());
            if (router[i] < minNum)
                minNum = router[i];
            if (router[i] > maxNum)
                maxNum = router[i];
        }

        Arrays.sort(router);

        int left = 1;
        int right = maxNum - minNum + 1; // right가 최대거리보다 더 커야 while문에서 돌 때

        while (left < right) {
            int mid = (right + left) / 2; // 중간 거리값

            int placedRouterCnt = 1; // 세운 공유기의 개수 , 가장 작은곳에 하나 뒀다고 가정하고 시작 -> 1에서 시작
            int prevRouter = 0; // 0번째 인덱스 == 가장 작은 곳
            // 현재 설정된 거리로 공유기 놔보기
            for (int i = 1; i < n; i++) {
                if (router[i] - router[prevRouter] >= mid) {
                    prevRouter = i;
                    placedRouterCnt++;
                }
            }
            if (placedRouterCnt >= c) // 만약 놓은 갯수가 많거나 같으면 거리를 늘려도 됨
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(left - 1);
    }
}

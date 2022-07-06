/***
 * 	402992kb
 * 	1996ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_2533 {

    private static ArrayList<Integer>[] list;
    private static boolean[] checked;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] rate = new int[n][2];
        list = new ArrayList[n];

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            if (list[from] == null) {
                list[from] = new ArrayList<>();
            }
            if (list[to] == null) {
                list[to] = new ArrayList<>();
            }
            list[from].add(to);
            list[to].add(from);
        }
        checked = new boolean[n];
        visited = new boolean[n];

        DFS(0, list[0]);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (checked[i])
                cnt++;
        }
        //System.out.println(Arrays.toString(checked));
        System.out.println(cnt);
    }

    private static boolean DFS(int index, ArrayList<Integer> arr) {
        if (arr.size() == 0) { //자식이 없음
            visited[index] = true;
            return false;
        }
        if (visited[index])
            return true;

        visited[index] = true;
        if (checked[index])
            return true;

        if (arr.size() > 0) {  //자식이 있다면
            boolean flg = true;
            for (Integer temp : arr) {//모든 자식 확인
                if (!DFS(temp, list[temp]))
                    flg = false;
            }
            if (!flg) {
                checked[index] = true;
            }
        }
        return checked[index];
    }
}

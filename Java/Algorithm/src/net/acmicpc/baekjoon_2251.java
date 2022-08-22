/***
 * 18384kb
 * 224ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_2251 {

    private static HashSet<Integer> set;
    private static int a;
    private static int b;
    private static int c;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        visited = new boolean[201][201];

        dfs(0, 0, c);
        Object[] arr = set.stream().toArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int z) {
        if (visited[x][y])
            return;

        if (x == 0) {
            set.add(z);
        }

        visited[x][y] = true;

        int leftA = a - x;
        int leftB = b - y;
        int leftC = c - z;

        // c -> b
        if (leftB < z)
            dfs(x, b, z - leftB);
        else
            dfs(x, y + z, 0);

        // c -> a
        if (leftA < z)
            dfs(a, y, z - leftA);
        else
            dfs(x + z, y, 0);

        // b -> a
        if (leftA < y)
            dfs(a, y - leftA, z);
        else
            dfs(x + y, 0, z);

        // b -> c
        if (leftC < y)
            dfs(x, y - leftC, c);
        else
            dfs(x, 0, z + y);

        // a -> b
        if (leftB < x)
            dfs(x - leftB, b, z);
        else
            dfs(0, y + x, z);

        // a -> c
        if (leftC < x)
            dfs(x - leftC, y, c);
        else
            dfs(0, y, z + x);
    }


}

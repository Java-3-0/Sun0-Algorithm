//39984kb,232ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1593 {
    private static int[] answer, myanswer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int cnt = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new int[128];
        myanswer = new int[128];

        char[] arr = bf.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            answer[arr[i]]++;
        }

        arr = bf.readLine().toCharArray();
        int first = 0;
        for (int i = 0; i < n; i++) {
            myanswer[arr[i]]++;
        }
        if (isSame())
            cnt++;

        for (int i = n; i < m; i++) {
            myanswer[arr[first++]]--;
            myanswer[arr[i]]++;
            if (isSame())
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isSame() {
        for (int i = 65; i < 91; i++) {
            if (answer[i] != myanswer[i]) return false;
        }
        for (int i = 97; i < 123; i++) {
            if (answer[i] != myanswer[i]) return false;
        }
        return true;
    }
}

package LineCoding;

import java.util.Arrays;
import java.util.Collections;

public class Solution5 {
    boolean[] visited;
    long answer;

    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        int[] ability = {7, 6, 8, 9, 10};
        sol.solution(ability, 1);
    }

    public long solution(int[] abilities, int k) {
        answer = 0;
        Integer[] a = new Integer[abilities.length];
        for (int i = 0; i < abilities.length; i++) {
            a[i] = abilities[i];
        }
        Arrays.sort(a, Collections.reverseOrder());
        visited = new boolean[abilities.length];
        CombinationMember(0, 0, k, abilities.length / 2, abilities.length, a);
        if (abilities.length % 2 == 1)
            CombinationMember(0, 0, k, abilities.length / 2 + 1, abilities.length, a);
        System.out.println(answer);
        return answer;
    }

    private void CombinationMember(int cnt, int index, int kCnt, int totalcount, int length, Integer[] abilities) {
        if (cnt == totalcount) {
            int num = 0;
            for (int i = 0; i < length; i += 2) {
                int used = 0;
                if (visited[i]) {
                    used += 1;
                    kCnt--;
                    num += abilities[i];
                }
                if (i + 1 < length && visited[i + 1]) {
                    used += 1;
                    num += abilities[i + 1];
                }

                if (used == 2 || (used == 0 && i + 1 < length)) return;
            }
            if (kCnt < 0) return;
            else {
                //answer = Math.max(answer, num);
                if (answer < num) {
                    answer = num;
                    System.out.println(answer);
                }
            }

            return;
        }

        if (index >= length) // 인원 벗어나면 안됨.
            return;

        visited[index] = true;
        CombinationMember(cnt + 1, index + 1, kCnt, totalcount, length, abilities);
        visited[index] = false;
        CombinationMember(cnt, index + 1, kCnt, totalcount, length, abilities);
    }
}


package LineCoding;

import java.util.HashSet;

public class Solution2 {

    private String[] keyboard;
    private boolean[] visited;
    private int answer;
    private HashSet<String> arr;
    private HashSet<String> canUse;


    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String[] str = {"line in line", "LINE", "in lion"};
        int num1 = sol.solution(str, 5);
        String[] str1 = {"ABcD", "bdbc", "a", "Line neWs"};
        int num2 = sol.solution(str1, 7);
        System.out.println(num1 + " " + num2);
    }

    public int solution(String[] sentences, int n) {
        answer = 0;
        arr = new HashSet<>();
        canUse = new HashSet<>();
        for (String str : sentences) {
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                if (now == ' ') continue;
                if (now >= 'A' && now <= 'Z')
                    arr.add("shift");
                arr.add(String.valueOf(Character.toLowerCase(now)));
            }
        }
        keyboard = new String[arr.size()];
        int i = 0;
        for (String s : arr) {
            keyboard[i++] = s;
        }
        visited = new boolean[arr.size()];
        Combination(0, 0, n, sentences);

        System.out.println(answer);
        return answer;
    }

    private void Combination(int cnt, int index, int n, String[] sentences) {
        if (cnt == n) {
//            System.out.println(arr);
//            System.out.println(Arrays.toString(visited));
            int num = checkScore(sentences);
            answer = Math.max(answer, num);
            return;
        }
        if (index == arr.size())
            return;

        visited[index] = true;
        canUse.add(keyboard[index]);
        Combination(cnt + 1, index + 1, n, sentences);
        canUse.remove(keyboard[index]);
        visited[index] = false;
        Combination(cnt, index + 1, n, sentences);
    }

    private int checkScore(String[] sentences) {
        int num = 0;
        for (String now : sentences) {
            num += getScore(now);
        }
        return num;
    }

    private int getScore(String now) {
        int upperCase = 0;
        for (int i = 0; i < now.length(); i++) {
            char ch = now.charAt(i);
            if (ch == ' ') continue;
            String key = String.valueOf(Character.toLowerCase(ch));
            if (ch >= 'A' && ch <= 'Z') {
                if (!canUse.contains("shift")) {
                    return 0;
                } else {
                    upperCase += 1;
                }
            }
            if (!canUse.contains(key)) {
                return 0;
            }
        }
        return now.length() + upperCase;
    }
}

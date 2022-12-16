package KakaoBlind2023;

public class Solution5 {

    private final int[] dx = {1, 0, 0, -1};
    private final int[] dy = {0, -1, 1, 0};
    private final String[] dir = {"d", "l", "r", "u"};

    public static void main(String[] args) {
        Solution5 sol = new Solution5();

        System.out.println(sol.solution(3, 4, 2, 3, 3, 1, 7));
        System.out.println(sol.solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(sol.solution(3, 3, 1, 2, 3, 3, 4));
    }

    public String solution(int n, int m, int startX, int startY, int endX, int endY, int k) {
        StringBuilder sb = new StringBuilder();
        while (startX != endX && startY != endY) {
            while (startX < endX) {
                sb.append("d");
                startX++;
            }
            while (startY > endY) {
                sb.append("l");
                startY--;
            }
            while (startY < endY) {
                sb.append("r");
                startY++;
            }
            while (startX > endX) {
                sb.append("u");
                startX--;
            }
        }

        if (sb.length() > k) {
            return "impossible";
        } else if (sb.length() == k) {
            return sb.toString();
        } else {
            if ((k - sb.length()) % 2 != 0)
                return "impossible";
            else {
                int first = (k - sb.length()) / 2;
                int second = first;
                while (first > 0 || second > 0) {
                    while (first > 0 && inRange(startX + 1, n)) {
                        sb.append("d");
                        startX++;
                        first--;
                    }
                    int left = first;
                    while (left > 0) {
                        while (startY > endY) {
                            sb.append("l");
                            startY--;
                        }
                        while (startY < endY) {
                            sb.append("r");
                            startY++;
                        }
                    }
                    while (second > 0 && inRange(startX - 1, n)) {
                        sb.append("u");
                        startX--;
                        second--;
                    }
                }

                return sb.toString();
            }
        }

    }


    private boolean inRange(int now, int n) {
        return now > 0 && now <= n;
    }

    private String DFS(int n, int m, int startX, int startY, int endX, int endY, int depth, String str) {
        if (depth == 0) {
            if (startX == endX && startY == endY) {
                return str;
            }
            return "";
        }

        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if (inRange(n, m, nextX, nextY)) {
                String temp = DFS(n, m, nextX, nextY, endX, endY, depth - 1, str + dir[i]);
                if (!temp.equals(""))
                    return temp;
            }
        }
        return "";
    }

    private boolean inRange(int n, int m, int nextX, int nextY) {
        return nextX > 0 && nextX <= n && nextY > 0 && nextY < m;
    }
}
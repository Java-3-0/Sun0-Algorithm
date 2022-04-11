package kr.co.programmers;

public class programmers_42897 {
    public static void main(String[] args) {
        programmers_42897 sol = new programmers_42897();
        int[] arr = {1, 2, 3, 1};
        sol.solution(arr);
    }

    public int solution(int[] money) {
        int answer = 0;
        int length = money.length;
        int[][] dp = new int[2][length + 1];

        dp[0][1] = 0;
        dp[1][1] = money[0];

        dp[0][2] = money[1];
        dp[1][2] = money[0];

        for (int i = 3; i < length; i++) {
            dp[0][i] = Math.max(money[i - 1] + dp[0][i - 2], dp[0][i - 1]);
            dp[1][i] = Math.max(money[i - 1] + dp[1][i - 2], dp[1][i - 1]);
        }
        dp[0][length] = Math.max(money[length - 1] + dp[0][length - 2], dp[0][length - 1]);
        dp[1][length] = dp[1][length - 1];

        answer = Math.max(dp[0][length], dp[1][length]);
        return answer;
    }
}

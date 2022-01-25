package kr.co.programmers;

public class programmers_43105 {

	public static void main(String[] args) {
		programmers_43105 sol = new programmers_43105();
		System.out
				.println(sol.solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));

	}

	public int solution(int[][] triangle) {
		int answer = 0;
		int n = triangle.length - 1;
		int[][] dp = new int[n + 1][];
		for (int i = 0; i < triangle.length; i++) {
			dp[i] = new int[triangle[i].length];
		}
		for (int i = 0; i < triangle[n].length; i++) {
			answer = Math.max(answer, findmax(dp, triangle, triangle.length - 1, i));
		}
		return answer;
	}

	int findmax(int[][] dp, int[][] triangle, int i, int j) {
		if (j < 0 || j >= triangle[i].length)
			return 0;
		if (i == 0)
			return triangle[i][0];
		if (dp[i][j] != 0)
			return dp[i][j];

		else {
			dp[i][j] = Math.max(findmax(dp, triangle, i - 1, j) + triangle[i][j],
					findmax(dp, triangle, i - 1, j - 1) + triangle[i][j]);

			return dp[i][j];
		}
	}
}

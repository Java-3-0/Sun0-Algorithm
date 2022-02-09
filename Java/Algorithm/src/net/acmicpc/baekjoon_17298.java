package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(bf.readLine());
		String[] arr = bf.readLine().split(" ");

		Stack<Integer> copy = new Stack<Integer>();
		int[] ans = new int[n];
		int index = n - 1;

		ans[index--] = -1;
		copy.push(Integer.parseInt(arr[n - 1]));

		for (int i = n - 2; i >= 0; i--) {
			int now = Integer.parseInt(arr[i]);
			while (!copy.empty() && copy.peek() <= now) {
				copy.pop();
			}
			if (copy.empty())
				ans[index--] = -1;
			else
				ans[index--] = copy.peek();
			copy.push(now);
		}
		for (int i = 0; i < n; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb.toString());
	}

}

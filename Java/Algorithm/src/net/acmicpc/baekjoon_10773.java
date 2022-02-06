// 24072kb, 252ms

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> st = new Stack<Integer>();

		int k = Integer.parseInt(bf.readLine());
		int num;
		for (int i = 0; i < k; i++) {
			num = Integer.parseInt(bf.readLine());
			if (num != 0)
				st.push(num);
			else
				st.pop();
		}
		int sum = 0;
		while (!st.empty()) {
			sum += st.pop();
		}
		System.out.println(sum);
	}

}

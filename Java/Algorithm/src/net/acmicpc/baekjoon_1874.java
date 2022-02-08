// 28572kb, 384ms

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		Stack<Integer> origin = new Stack<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		int num = 0;

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= n; t++) {
			int now = Integer.parseInt(bf.readLine());
			while (now > num) {
				st.push(++num);
				sb.append("+\n");
			}
			if (now == st.peek()) {
				origin.push(st.pop());
				sb.append("-\n");
			}
		}
		if (st.empty())
			System.out.println(sb.toString());
		else
			System.out.println("NO");
	}

}

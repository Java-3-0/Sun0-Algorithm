// 15016kb, 156ms

package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= num; t++) {
			String[] parenthesis = bf.readLine().split("");
			Stack<String> st = new Stack<String>();
			String flg = "YES";
			aa: for (String now : parenthesis) {
				switch (now) {
				case "(":
				case "[":
				case "{":
				case "<":
					st.push(now);
					break;
				case ")":
				case "]":
				case "}":
				case ">":
					if (st.empty() || !st.pop().equals(pairof(now))) {
						flg = "NO";
						break aa;
					}
					break;
				}
			}
			if (!st.empty() && flg.equals("YES"))
				flg = "NO";
			System.out.println(flg);
		}
	}

	private static String pairof(String now) {
		switch (now) {
		case ")":
			return "(";
		case "]":
			return "[";
		case "}":
			return "{";
		case ">":
			return "<";
		}
		return now;
	}

}

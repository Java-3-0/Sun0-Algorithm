// 43536kb, 528ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_4949 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] parenthesis = bf.readLine().split("");
		while (!parenthesis[0].equals(".")) {
			Stack<String> st = new Stack<String>();
			String flg = "yes";
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
						flg = "no";
						break aa;
					}
					break;
				default:
					break;
				}
			}
			if (!st.empty() && flg.equals("yes"))
				flg = "no";
			System.out.println(flg);
			parenthesis = bf.readLine().split("");
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

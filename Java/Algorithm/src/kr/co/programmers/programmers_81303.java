package kr.co.programmers;

import java.util.ArrayList;
import java.util.Stack;

public class programmers_81303 {

	public static void main(String[] args) {
		programmers_81303 sol = new programmers_81303();
		sol.solution(8, 2, new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" });
	}

	public String solution(int n, int k, String[] cmd) {
		String answer = "";
		ArrayList<Integer> original = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		// 현재 위치
		int now = k;

		for (int i = 0; i < n; i++) {
			original.add(i);
		}

		for (int i = 0; i < cmd.length; i++) {
			System.out.println(now);
			String[] command = cmd[i].split(" ");
			switch (command[0]) {
			case "D":
				now += Integer.parseInt(command[1]);
				break;
			case "U":
				now -= Integer.parseInt(command[1]);
				break;
			case "C":
				original.remove(now);
				stack.push(now);
				break;
			// 다시 삽입시 에러남
			case "Z":
				int back = stack.pop();
				original.add(back, back);
				break;
			default:

			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(original.get(i));
		}
		return answer;
	}
}

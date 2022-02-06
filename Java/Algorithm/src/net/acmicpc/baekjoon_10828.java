// 17992kb, 360ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> st = new Stack<Integer>();

		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			String[] command = bf.readLine().split(" ");

			switch (command[0]) {
			case "push":
				st.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				try {
					System.out.println(st.pop());
				} catch (Exception e) {
					System.out.println("-1");
				}
				break;
			case "size":
				System.out.println(st.size());
				break;
			case "empty":
				if (st.size() == 0)
					System.out.println("1");
				else
					System.out.println("0");
				break;
			case "top":
				try {
					System.out.println(st.peek());
				} catch (Exception e) {
					System.out.println("-1");
				}
				break;
			}
		}
	}

}

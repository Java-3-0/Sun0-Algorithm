//24316kb,188ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = bf.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			que.offer(i);

		sb.append("<");
		while (true) {
			for (int i = 0; i < k - 1; i++) {
				que.offer(que.poll());
			}
			int number = que.poll();
			if (que.isEmpty()) {
				sb.append(number + ">");
				break;
			} else
				sb.append(number + ", ");
		}
		System.out.println(sb.toString());

	}

}

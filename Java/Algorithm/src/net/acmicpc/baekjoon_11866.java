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

		// 1~n까지 큐에 삽입
		for (int i = 1; i <= n; i++)
			que.offer(i);

		sb.append("<");
		while (true) {

			// k번째를 빼기 위해 1 ~ (k-1) 번째는 앞에서 빼서 뒤로 넣기
			for (int i = 0; i < k - 1; i++) {
				que.offer(que.poll());
			}

			// k번째 빼기
			int number = que.poll();

			// 만약에 뺐는데 큐가 비었으면 종료
			if (que.isEmpty()) {
				sb.append(number + ">");
				break;
			} else
				sb.append(number + ", ");
		}
		System.out.println(sb.toString());

	}

}
